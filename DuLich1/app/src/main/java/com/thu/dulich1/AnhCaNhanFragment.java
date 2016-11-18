package com.thu.dulich1;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageBase64;
import com.kosalgeek.android.photoutil.ImageLoader;
import com.kosalgeek.android.photoutil.PhotoLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import thu.singleton.MySingleton;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnhCaNhanFragment extends Fragment {

String username;
    EditText ed,ed2;
    ImageView anhdaidien, doianh, sup;
    GalleryPhoto galleryPhoto;
    final int GALLERY_REQUEST = 22131;
    String selectedPhoto;
    Bitmap bitmap;
    File file;
    String i = null;
    String a;
    String kq = "";
    public AnhCaNhanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_anh_ca_nhan, container, false);


        anhdaidien = (ImageView)view.findViewById(R.id.mypicture);
        doianh = (ImageView)view.findViewById(R.id.anhdaidien);
        sup = (ImageView)view.findViewById(R.id.sup);
        Bundle b = getArguments();
        a = b.getString("doctor_id");
        Toast.makeText(AnhCaNhanFragment.this.getActivity(),a, Toast.LENGTH_SHORT).show();

        galleryPhoto = new GalleryPhoto(AnhCaNhanFragment.this.getActivity());


        anhdaidien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = galleryPhoto.openGalleryIntent();
                startActivityForResult(in, GALLERY_REQUEST);
            }
        });
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kq = (String.valueOf(Random()));
                try {
                    String url = "http://192.168.56.1:8080/dulichviet/updavatar.php";


                    bitmap = ImageLoader.init().from(selectedPhoto).requestSize(1024,1024).getBitmap();


                    final String encodeIamge = ImageBase64.encode(bitmap);

                    StringRequest stringRequest = new StringRequest(Request.Method.POST,

                            url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.contains("thanhcong")){
                                Toast.makeText(AnhCaNhanFragment.this.getActivity()," cap nhat thanh cong", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(AnhCaNhanFragment.this.getActivity()," cap nhat khong thanh cong", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            //  Toast.makeText(CapNhatFragment.this.getActivity(), "L0i roi", Toast.LENGTH_SHORT).show();

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {


                            Map<String, String> parms = new HashMap<>();

                            parms.put("username", a);

                            parms.put("hinhanh", file.getName().toString().replace(file.getName().toString(),gio()+kq+".jpeg"));

                            return parms;
                        }
                    };//ket thuc stringresquet

                    String url1 = "http://192.168.56.1:8080/dulichviet/uplavatar.php";
                    StringRequest stringRequest1 = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(AnhCaNhanFragment.this.getActivity(),response, Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Toast.makeText(CapNhatFragment.this.getActivity(),"loi upload", Toast.LENGTH_SHORT).show();
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();

                            params.put("i", encodeIamge);
                            params.put("r", kq);

                            return params;
                        }
                    };
                    MySingleton.getInstance(AnhCaNhanFragment.this.getActivity()).addToRequestQueue(stringRequest1);


                    MySingleton.getInstance(AnhCaNhanFragment.this.getActivity()).addToRequestQueue(stringRequest);
                } catch (FileNotFoundException e) {
                    // Toast.makeText(CapNhatFragment.this.getActivity(),"Loi anhhhhh",Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == GALLERY_REQUEST){
                galleryPhoto.setPhotoUri(data.getData());
                String photoPath = galleryPhoto.getPath();
                selectedPhoto = photoPath;
                file = new File(photoPath);
                i = file.getName().toString();

                try {
                    Bitmap bitmap =  PhotoLoader.init().from(photoPath).requestSize(512,512).getBitmap();

                    anhdaidien.setImageBitmap(bitmap);




                } catch (FileNotFoundException e) {
                    Toast.makeText(AnhCaNhanFragment.this.getActivity(),"Loi anh",Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public String gio(){
        Date date = new Date();
        SimpleDateFormat formats = new SimpleDateFormat("yyyyMMdd");
        String daynew =	formats.format(date);
        return daynew;
    }
    public int Random(){
        //tong tu 10 den 19
        Random rand = new Random();
        int num = rand.nextInt(10000000);
        return num;

    }

}

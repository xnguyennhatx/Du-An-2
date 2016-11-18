package com.thu.dulich1;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageBase64;
import com.kosalgeek.android.photoutil.ImageLoader;
import com.kosalgeek.android.photoutil.PhotoLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import thu.bean.GPSTracker;
import thu.singleton.MySingleton;

import static android.app.Activity.RESULT_OK;


public class ThemFragment extends Fragment {
    String kq = null;
    Bitmap bitmap;
    String i = null;
    String username;
    File file;
    EditText edMota,edChitiet;
    final String TAG = this.getClass().getSimpleName();
    ImageView imgAnh, btThemanh, btDang, btCamera;
    Button  btGPS;
    String ipAdd = "";
    GalleryPhoto galleryPhoto;
    CameraPhoto cameraPhoto;
    final int GALLERY_REQUEST = 13323;
    final int CAMERA_REQUEST = 33331;
    String selectedPhoto;
    String ava, lat, lang;
    GPSTracker gps;
    TextView tvLat,tvLang;
    double latitude, longitude;
    String arr[]={
            "Điểm phượt đẹp",
            "Thiên nhiên đẹp",
            "Khác.."};

    public ThemFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_them, container, false);
        edMota = (EditText)view.findViewById(R.id.mota);
        edChitiet = (EditText)view.findViewById(R.id.chitiet);
        btThemanh = (ImageView)view.findViewById(R.id.chonanh);
        btDang = (ImageView)view.findViewById(R.id.dang);
        btGPS = (Button)view.findViewById(R.id.gps);
        btCamera = (ImageView)view.findViewById(R.id.camera);
        tvLat = (TextView)view.findViewById(R.id.lat);
        tvLang = (TextView)view.findViewById(R.id.lang);
        imgAnh = (ImageView)view.findViewById(R.id.ivImages);
        Spinner sp = (Spinner)view.findViewById(R.id.sp);

        Bundle b = getArguments();
        username = b.getString("doctor_id");
        Bundle c = getArguments();
        ava = c.getString("avatar");
        Toast.makeText(ThemFragment.this.getActivity(), ava , Toast.LENGTH_LONG).show();
        imgAnh.setEnabled(true);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (
                        this.getActivity(),
                        android.R.layout.simple_spinner_item,
                        arr
                );
        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity().)
                //mota.setText(""+(position + 1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(ThemFragment.this.getActivity());

                // check if GPS enabled
                if(gps.canGetLocation()){

                     latitude = gps.getLatitude();
                     longitude = gps.getLongitude();
                    lat  = String.valueOf(latitude);
                    lang  = String.valueOf(longitude);
                   tvLat.setText("Kinh Độ: "+latitude);
                    tvLang.setText("Vĩ Độ: "+longitude);
                   // Toast.makeText(ThemFragment.this.getActivity(), ""+ , Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }
            }
        });

        cameraPhoto = new CameraPhoto(ThemFragment.this.getActivity());
        galleryPhoto = new GalleryPhoto(ThemFragment.this.getActivity());
        btThemanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = galleryPhoto.openGalleryIntent();

                startActivityForResult(in, GALLERY_REQUEST);

            }
        });
        btCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent in = cameraPhoto.takePhotoIntent();
                    startActivityForResult(in, CAMERA_REQUEST);
                    cameraPhoto.addToGallery();
                }catch(IOException e){

                }

            }
        });

        btDang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



        if(getActivity().getIntent().getExtras().getString("ipAdd")==null){
            ipAdd = "192.168.56.1";
        }else{
            ipAdd = getActivity().getIntent().getExtras().getString("ipAdd");
        }



        kq = (String.valueOf(Random()));
        try {
            String url = "http://"+ipAdd+":8080/dulichviet/insert.php";


            bitmap = ImageLoader.init().from(selectedPhoto).requestSize(1024,1024).getBitmap();


            final String encodeIamge = ImageBase64.encode(bitmap);

            StringRequest stringRequest = new StringRequest(Request.Method.POST,

                    url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if(response.contains("thanhcong")){
                        Toast.makeText(ThemFragment.this.getActivity()," them thanh cong", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(ThemFragment.this.getActivity()," them khong thanh cong", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(ThemFragment.this.getActivity(), "L0i roi", Toast.LENGTH_SHORT).show();

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {


                    Map<String, String> parms = new HashMap<>();
                    parms.put("username", username);
                    parms.put("mota", edMota.getText().toString());
                    parms.put("chitiet", edChitiet.getText().toString());
                    parms.put("hinhanh", file.getName().toString().replace(file.getName().toString(),gio()+kq+".jpeg"));
                    parms.put("ngaydang", ngayDang());
                    parms.put("iddanhmuc", "1");
                    parms.put("binhluan", ava);
                    parms.put("lat", lat);
                    parms.put("lang", lang);
                   // Toast.makeText(ThemFragment.this.getActivity(),"kakakakakak", Toast.LENGTH_SHORT).show();
                    //Log.d("eeeeeeeeeeeeee",kq);
                    return parms;
                }
            };//ket thuc stringresquet

            String url1 = "http://"+ipAdd+":8080/dulichviet/upload.php";
            StringRequest stringRequest1 = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(ThemFragment.this.getActivity(),response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                   // Toast.makeText(ThemFragment.this.getActivity(),"loi upload", Toast.LENGTH_SHORT).show();
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
            MySingleton.getInstance(ThemFragment.this.getActivity()).addToRequestQueue(stringRequest1);


            MySingleton.getInstance(ThemFragment.this.getActivity()).addToRequestQueue(stringRequest);
        } catch (FileNotFoundException e) {
           // Toast.makeText(ThemFragment.this.getActivity(),"Loi anhhhhh",Toast.LENGTH_SHORT).show();
        }

        }
    });



        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == CAMERA_REQUEST){

                String photoPath = cameraPhoto.getPhotoPath();
                selectedPhoto = photoPath;
                file = new File(photoPath);
                i = file.getName().toString();
                Bitmap bitmap = null;
               // selectedPhoto = photoPath;

                try {
                    bitmap =  PhotoLoader.init().from(photoPath).requestSize(512,512).getBitmap();
                    imgAnh.setEnabled(false);
                    imgAnh.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    //Toast.makeText(ThemFragment.this.getActivity(),"Loi anh",Toast.LENGTH_SHORT).show();
                }
            }

           else if(requestCode == GALLERY_REQUEST){
                galleryPhoto.setPhotoUri(data.getData());
                String photoPath = galleryPhoto.getPath();
                selectedPhoto = photoPath;
                file = new File(photoPath);
                i = file.getName().toString();
                try {
                    Bitmap bitmap =  PhotoLoader.init().from(photoPath).requestSize(512,512).getBitmap();
                    imgAnh.setEnabled(false);
                    imgAnh.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    //Toast.makeText(ThemFragment.this.getActivity(),"Loi anh",Toast.LENGTH_SHORT).show();
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
    public String ngayDang(){
        Date date = new Date();
        SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
        String daynews=	formats.format(date);
        return daynews;
    }
}

package com.thu.dulich1;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.amigold.fundapter.interfaces.ItemClickListener;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.JsonSyntaxException;
import com.kosalgeek.android.json.JsonConverter;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import thu.bean.BinhLuan;
import thu.bean.TinTuc;
import thu.singleton.MySingleton;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddNewsActivityFragment extends Fragment {


    String a =null;
    int view = 0;
    String nguoidung;
    ListView lvTT;
    String username;
    String lat , lang;

    ArrayList<TinTuc> tintuctList;
    FunDapter<TinTuc> adapter;
    SwipeRefreshLayout refreshLayout;



    public AddNewsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_add_news, container, false);
        lvTT = (ListView)view.findViewById(R.id.lvTinTuc);


        loadusers();

        Bundle b = getArguments();
        username = b.getString("doctor_id");
       // lv.setText(a);
        Toast.makeText(AddNewsActivityFragment.this.getActivity(), "hello: " + username, Toast.LENGTH_SHORT).show();


        loadData();
        refreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe);
        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                loadData();
            }
        });
        registerForContextMenu(lvTT);




    return view;
    }



    private void loadusers(){

        String url = "http://192.168.56.1:8080/dulichviet/users.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,

                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonText) {
                if (jsonText.contains("thanhcong")) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Toast.makeText(AddNewsActivityFragment.this.getActivity(), "L0iiiiii roi", Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String> parms = new HashMap<>();
                parms.put("username", a);
                // Log.d("cccccccccccccccc", b);
                return parms;
            }
        };//ket thuc stringresquet
        MySingleton.getInstance(AddNewsActivityFragment.this.getActivity()).addToRequestQueue(stringRequest);

    }//ket thuc loaduser

    private void loadData(){
        String url = "http://192.168.56.1:8080/dulichviet/tintuc.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String jsonText) {
                        try{
                        tintuctList = new JsonConverter<TinTuc>().toArrayList(jsonText, TinTuc.class);
                        BindDictionary<TinTuc> dictionary = new BindDictionary<>();
                        dictionary.addStringField(R.id.tvusername, new StringExtractor<TinTuc>() {
                            @Override
                            public String getStringValue(TinTuc tt, int position) {
                                nguoidung = tt.getUsername();
                                Toast.makeText(AddNewsActivityFragment.this.getActivity(), nguoidung, Toast.LENGTH_SHORT).show();
                                return tt.getUsername();
                            }
                        }).onClick(new ItemClickListener<TinTuc>() {
                            @Override
                            public void onClick(TinTuc item, int position, View view) {
                                Intent intent = new Intent(getActivity(), XemNguoiDungActivity.class);
                                intent.putExtra("nguoidung", nguoidung);
                                intent.putExtra("username", username);
                                startActivity(intent);
                            }
                        });

                        dictionary.addStringField(R.id.tvngaydang, new StringExtractor<TinTuc>() {
                            @Override
                            public String getStringValue(TinTuc tt, int position) {


                                return tt.getNgaydang();
                            }
                        });

                        dictionary.addStringField(R.id.tvmota, new StringExtractor<TinTuc>() {
                            @Override
                            public String getStringValue(TinTuc tt, int position) {
                                return tt.getMota();
                            }
                        });



                        dictionary.addStringField(R.id.tvthich, new StringExtractor<TinTuc>() {
                            @Override
                            public String getStringValue(TinTuc tt, int position) {
                                return "" + tt.getThich()+" Bình luận";
                            }
                        }).onClick(new ItemClickListener<TinTuc>() {
                            @Override
                            public void onClick(TinTuc item, int position, View view) {
                                Intent in = new Intent(getActivity(), BinhluanActivity.class);
                                TinTuc tinTuc = tintuctList.get(position);

                                in.putExtra("xem",tinTuc.getMand());
                                in.putExtra("tintuc", tinTuc);
                                in.putExtra("username", username);
                                startActivity(in);

                            }

                        });

                        dictionary.addStringField(R.id.tvxem, new StringExtractor<TinTuc>() {
                            @Override
                            public String getStringValue(TinTuc tt, int position) {
                                return "" + tt.getXem()+" Lượt xem";
                            }
                        });

                        dictionary.addStringField(R.id.tvvitri, new StringExtractor<TinTuc>() {
                            @Override
                            public String getStringValue(TinTuc tt, int position) {
                              // lat = tt.getLat();
                               //Toast.makeText(AddNewsActivityFragment.this.getActivity(), "lllllllll" + lat, Toast.LENGTH_SHORT).show();
                              // lang = tt.getLang();
                                Toast.makeText(AddNewsActivityFragment.this.getActivity(), tt.getLang()+": "+ tt.getLat(), Toast.LENGTH_SHORT).show();

                                return tt.getLat();

                            }
                        }).onClick(new ItemClickListener<TinTuc>() {
                            @Override
                            public void onClick(TinTuc item, int position, View view) {
//                                Intent intent = new Intent(getActivity(), ViTriActivity.class);
//                                intent.putExtra("lat", lat);
//                                intent.putExtra("lang", lang);
//                                startActivity(intent)

//                                Intent sendIntent = new Intent(Intent.ACTION_SEND);
//                                sendIntent.setType("text/plain");
//                                //sendIntent.putExtra(Intent.EXTRA_SUBJECT, "My image");
//                              //  sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(String.valueOf(R.drawable.circularimage))));// this is for image . here filename_toshare is your file path.
//                                sendIntent.putExtra(Intent.EXTRA_TEXT, "My Image ");// this is for text
//                                startActivity(Intent.createChooser(sendIntent, "Email:"));



                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_TEXT, "http://www.google.fr/");
                                startActivity(Intent.createChooser(intent, "Share with"));


//                                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
//                                shareIntent.setType("text/plain");
//                                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Content to share");
//                                PackageManager pm = view.getContext().getPackageManager();
//                                List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
//                                for (final ResolveInfo app : activityList) {
//                                    if ((app.activityInfo.name).contains("facebook")) {
//                                        final ActivityInfo activity = app.activityInfo;
//                                        final ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
//                                        shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//                                        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//                                        shareIntent.setComponent(name);
//                                        view.getContext().startActivity(shareIntent);
//                                        break;
//                                    }
//                                }


                            }

                        });
                        dictionary.addDynamicImageField(R.id.imanh, new StringExtractor<TinTuc>() {
                                    @Override
                                    public String getStringValue(TinTuc tt, int position) {
                                        String path = "http://192.168.56.1:8080/dulichviet/images/"+ tt.getHinhanh() + "";
                                        //String path = null;

                                        return path ;
                                    }
                                },
                                new DynamicImageLoader() {
                                    @Override
                                    public void loadImage(String url, ImageView imageView) {
                                        Picasso.with(AddNewsActivityFragment.this.getActivity())
                                                .load(url)
                                                .placeholder(R.drawable.hodler)
                                                .error(R.drawable.ic_launcher)
                                                .into(imageView);
                                    }
                                }
                        );

                        dictionary.addDynamicImageField(R.id.imuser, new StringExtractor<TinTuc>() {
                                    @Override
                                    public String getStringValue(TinTuc tt, int position) {
                                        String path = "http://192.168.56.1:8080/dulichviet/images/"+ tt.getBinhluan() + "";
                                        //String path = null;

                                        return path ;
                                    }
                                },
                                new DynamicImageLoader() {
                                    @Override
                                    public void loadImage(String url, ImageView imageView) {
                                        Picasso.with(AddNewsActivityFragment.this.getActivity())
                                                .load(url)
                                                .placeholder(R.drawable.hodler)
                                                .error(R.drawable.ic_launcher)

                                                .into(imageView);

                                    }
                                }
                        );
                        adapter = new FunDapter<>(
                                AddNewsActivityFragment.this.getActivity(),
                                tintuctList,
                                R.layout.tintuc_layout,
                                dictionary

                        );
                        lvTT.setAdapter(adapter);
                        } catch(IllegalStateException | JsonSyntaxException exception) {

                        }
                        lvTT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                Intent in = new Intent(getActivity(), ChiTietActivity.class);
                                TinTuc tinTuc = tintuctList.get(position);

                                in.putExtra("xem",tinTuc.getMand());
                                in.putExtra("tintuc", tinTuc);
                                in.putExtra("username", username);
                                startActivity(in);
                            }

                        });
                        if(refreshLayout.isRefreshing()) {
                            refreshLayout.setRefreshing(false);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       // Toast.makeText(AddNewsActivityFragment.this.getActivity(),"Loi", Toast.LENGTH_LONG).show();
                       if(refreshLayout.isRefreshing()) {
                           refreshLayout.setRefreshing(false);
                       }
                    }
                }
        );
        MySingleton.getInstance(AddNewsActivityFragment.this.getActivity()).addToRequestQueue(stringRequest);

    }


}

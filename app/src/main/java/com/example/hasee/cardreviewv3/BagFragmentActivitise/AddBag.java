package com.example.hasee.cardreviewv3.BagFragmentActivitise;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hasee.cardreviewv3.R;
import com.example.hasee.cardreviewv3.ReviewFragmentActivitise.DialogchoosebagActivity;
import com.example.hasee.cardreviewv3.UtilsClass.MyGlideEngine;
import com.example.hasee.cardreviewv3.UtilsClass.UriToPathUtil;
import com.example.hasee.cardreviewv3.viewBase.MyDialog;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * 创建卡包的
 */
public class AddBag extends AppCompatActivity implements View.OnClickListener{
    private static final int REQUEST_CODE_CHOOSE = 23;
    public EditText bagdescription;//卡包的描述
    private ImageView back;//返回的按钮
    private ImageView ok;//完成
    private View choose;
    private ImageView bagcover;  //卡包的封面展示
    private Button choosebagcover;//选择卡片封面按钮

    private MyDialog dialog;//选择卡片dialog
    private Button choosecardkind;//选择卡片类型的按钮
    private LinearLayout linearLayout;//动态加载的布局
    private LayoutInflater inflater;
    private Bitmap bitmap; //卡包封面文件
    private String s; //返回的cook
    private File f; //图片文件
    private Uri imageURL;
    private String path;
    private String URL;//返回的图片的封面

    private String Bagname;



    private ImageView text; //测试的

    private boolean FLAG_PERMISSION = false;

    private List<String> list;

    private String token;//上传图片的token



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bag);
        init();
        SharedPreferences preferences = getSharedPreferences("Token",MODE_PRIVATE);
        token = preferences.getString("Token","");





}

    /**
     * 绑定
     */

    private void init(){
        back = (ImageView)findViewById(R.id.iv_back);
        choosebagcover = (Button)findViewById(R.id.btn_bag_choosebagcover);
        bagcover = (ImageView)findViewById(R.id.iv_bag_cover1);
        choose = (LinearLayout)findViewById(R.id.ll_bag_imag);
        ok = (ImageView)findViewById(R.id.iv_save);
        text = (ImageView)findViewById(R.id.iv_text);
        choosecardkind = (Button)findViewById(R.id.btn_bag_choosestyle);
        bagdescription = (EditText)findViewById(R.id.et_bah_name);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("233","啦啦啦");
                finish();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("233","啦啦啦呜呜呜");
                //getimagereturn();
               updata();

                //upAddBag();//上传卡包

            }

        });
        choosebagcover.setOnClickListener(this);
        choosecardkind.setOnClickListener(this);



    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bag_choosebagcover:
                if (ContextCompat.checkSelfPermission(AddBag.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(AddBag.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }else {
                    Matisse.from(this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.example.hasee.cardreviewv3.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .imageEngine(new MyGlideEngine())//图片加载引擎
                            .forResult(REQUEST_CODE_CHOOSE);//
                }
                break;
            case R.id.btn_bag_choosestyle:
                Intent intentchoose = new Intent(AddBag.this,DialogchoosebagActivity.class);
                startActivityForResult(intentchoose,22);



        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Matisse.from(this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .thumbnailScale(1)
                            .theme(R.style.Matisse_Zhihu)
                            .captureStrategy(new CaptureStrategy(true, "com.example.hasee.cardreviewv3.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(REQUEST_CODE_CHOOSE);//
                }else {
                    Toast.makeText(this,"啦啦啦",Toast.LENGTH_SHORT).show();
                }
            case 33:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }else {
                    Toast.makeText(this,"你给了权限",Toast.LENGTH_SHORT).show();
                }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //卡包图片选择的
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            List<Uri> result = Matisse.obtainResult(data);

          //  Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(result.get(0)));
          //  Drawable drawable = new BitmapDrawable(bitmap);

           // bagcover.setBackground(drawable);
          // bagcover.setImageBitmap(bitmap);

            bagcover.setImageURI(result.get(0));

            imageURL = result.get(0);
            path = UriToPathUtil.getRealFilePath(getBaseContext(),imageURL);
           // path = "file://" + path;


           // Bitmap bitmap = BitmapFactory.decodeFile(path);
            //f = convertBitmapToFile(bitmap);
           // text.setImageBitmap(bitmap);

        }
        switch (requestCode){
            //卡包类型选择的
            case 22:
                if (resultCode == RESULT_OK){
                    String bagkind = data.getStringExtra("kind_return");
                    Toast.makeText(this,"卡包类型 "+bagkind,Toast.LENGTH_SHORT).show();
                    choosecardkind.setText(bagkind);
                }
                break;
        }


    }
    /**
     * 获取图片的返回的URL的
     */
    private void getimagereturn() {
                Log.d("233",imageURL.toString() + "   "+path);


                File ff = new File(path);


        //RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"),new File(path));
              // RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),f);
                 RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),ff);


                MultipartBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("image","image",requestBody).build();



                //OkHttpClient client = new OkHttpClient();

                OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(600, TimeUnit.SECONDS)
                .readTimeout(200, TimeUnit.SECONDS)
                .writeTimeout(600, TimeUnit.SECONDS)
                .build();



                Request request = new Request.Builder()
                        .url("http://diamond.creatshare.com/upload")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("233","请求错误");

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String str = response.body().string();

                        Log.d("233",str);
                    }
                });

            }
    /**
     * 获取返回的Token
     */
    public static String getToken(){
        return null;

    }

    /***
     * Retrofit上传图片
     */
    public void updata(){
        File file = new File(path);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://diamond.creatshare.com")
                .build();

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);

        MultipartBody.Part body = MultipartBody.Part.createFormData("image","image.png",requestBody);

        upload se = retrofit.create(upload.class);
        se.call(body).enqueue(new retrofit2.Callback<ResponseBody>() {
                    @Override
                    public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                     try {
                         URL = returnURL(response.body().string());

                         Log.d("233","URL   "+URL);


                         Log.d("233",response.body().string());

                         upAddBag();


                     }catch (Exception e){
                         e.printStackTrace();
                     }
                    }

                    @Override
                        public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                        Log.d("233","请求失败"+t);

                    }
                });

    }

    /**
     * 解析json数据
     * @param s
     * @return
     */
    public String returnURL(String s){
        String returnURL = "返回失败";
        if (s!=null){
            try {
                JSONObject jsonObject = new JSONObject(s);
                String data = jsonObject.getString("data");
                JSONObject jsonObject1 = new JSONObject(data);
                String ss = jsonObject1.getString("imageUrl");



                return ss;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return returnURL;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    /**
     * 上传卡包
     */
    public void upAddBag(){
        Log.d("233","上传图片");
        Log.d("233","上传图片1");
        Bagname = bagdescription.getText().toString();
        Log.d("233","description"+Bagname);

        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();

                RequestBody requestBody = new FormBody.Builder()
                        .add("description",Bagname)
                        .add("cover",URL)
                        .add("type","1")
                        .build();

                Request request = new Request.Builder()
                        .url("http://diamond.creatshare.com/package/add")
                        .post(requestBody)
                        .addHeader("Authorization",token)
                        .build();

                Call call = client.newCall(request);
                try {
                    Response response = call.execute();
                    Log.d("233",response.body().string());
                    Headers requestHeaders= response.networkResponse().request().headers();
                    //Log.d("233",requestHeaders.toString());

                }catch (IOException e){
                    e.printStackTrace();
                }


            }
        }).start();


    }

}




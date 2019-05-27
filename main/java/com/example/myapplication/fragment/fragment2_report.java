package com.example.myapplication.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.transfer.sendReport;
import com.zxy.tiny.Tiny;
import com.zxy.tiny.callback.FileWithBitmapCallback;

import org.feezu.liuli.timeselector.TimeSelector;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class fragment2_report extends Activity {
    //调取系统摄像头的请求码
    private static final int MY_ADD_CASE_CALL_PHONE = 6;
    //打开相册的请求码
    private static final int MY_ADD_CASE_CALL_PHONE2 = 7;
    private ImageView imageView;

    String photo="123";
    TextView Report_info_name;
    TextView Report_info_name_input;
    TextView Report_info_number;
    TextView Report_info_number_input;
    TextView Report_info_date;
    TextView Report_info_date_input;
    TextView Report_info_phone;
    TextView Report_info_phone_input;
    TextView Report_Form;


    TextView Report_form_time;
    TextView Report_form_location;
    TextView Report_form_detail ;

    TextView Report_form_time_input ;
    EditText Report_form_location_input;
    EditText Detail_form_location_input;
//    Button Report_button_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment2_report);
        Report_info_name = findViewById(R.id.Report_info_name);
        Report_info_name_input = findViewById(R.id.Report_info_name_input);
        Report_info_number = findViewById(R.id.Report_info_number);
        Report_info_number_input = findViewById(R.id.Report_info_number_input);
        Report_info_date = findViewById(R.id.Report_info_date);
        Report_info_date_input = findViewById(R.id.Report_info_date_input);
        Report_info_phone = findViewById(R.id.Report_info_phone);
        Report_info_phone_input = findViewById(R.id.Report_info_phone_input);
//        Report_info_type = findViewById(R.id.Report_info_type);
//        Report_info_type_input = findViewById(R.id.Report_info_type_input);
        Report_Form=findViewById(R.id.Report_Form);
        Report_form_time = findViewById(R.id.Report_form_time);
        Report_form_location = findViewById(R.id.Report_form_location);
        Report_form_detail = findViewById(R.id.Report_form_detail);
//        Report_button_submit=findViewById(R.id.Report_button_picture);

        Report_Form.setText(R.string.Report_Form);
        Report_form_time.setText(R.string.timeof);
        Report_form_location.setText(R.string.location);
        Report_form_detail.setText(R.string.detail);
//        Report_button_submit.setText(R.string.submit);



        Report_form_time_input = findViewById(R.id.Report_form_time_input);
        Report_form_location_input = findViewById(R.id.Report_form_location_input);
        Detail_form_location_input = findViewById(R.id.Report_form_detail_input);
        final String name=getIntent().getStringExtra("nameinput");

        Report_form_time_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date curDate = new Date(System.currentTimeMillis());
                String date = formatter.format(curDate);

                TimeSelector timeSelector = new TimeSelector(fragment2_report.this, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
//                        Toast.makeText(fragment2_report.this, time, Toast.LENGTH_SHORT).show();
                        Report_form_time_input.setText(time);
                    }
                }, "2019-01-01 00:00", "2019-12-31 23:59:59");

                timeSelector.setIsLoop(false);//设置不循环,true循环

                timeSelector.setMode(TimeSelector.MODE.YMDHM);//显示 年月日时分（默认）
//        timeSelector.setMode(TimeSelector.MODE.YMD);//只显示 年月日

                timeSelector.show();
            }
        });





        Button Report_button_submit = findViewById(R.id.Report_button_submit);
        Report_button_submit.setText(R.string.submit);
        Report_button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    final String location = Report_form_location_input.getText().toString();
                    final String time = Report_form_time_input.getText().toString();
                    final String message = Detail_form_location_input.getText().toString();
                    @Override
                    public void run(){
                        if(location.equals("")){
                            Looper.prepare();
                            AlertDialog.Builder builder  = new AlertDialog.Builder(fragment2_report.this);
                            builder.setTitle(R.string.t) ;
                            builder.setMessage(R.string.nolocation ) ;
                            builder.setPositiveButton(R.string.yes,null );
                            builder.show();
                            Looper.loop();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else if(time.equals("")||message.equals("")||photo.equals("")){
                            Looper.prepare();
                            AlertDialog.Builder builder  = new AlertDialog.Builder(fragment2_report.this);
                            builder.setTitle(R.string.t) ;
                            builder.setMessage(R.string.noinfor ) ;
                            builder.setPositiveButton(R.string.yes,null );
                            builder.show();
                            Looper.loop();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            sendReport sr = new sendReport(name, location, time, message, photo);
                            Looper.prepare();
                            Toast.makeText(getApplicationContext(), R.string.submitss, Toast.LENGTH_SHORT).show();
                            fragment2_report.this.finish();
                            Looper.loop();
                        }
                    }

                };

                thread.start();

            }
        });




        Report_info_name.setText(getIntent().getStringExtra("name"));
        Report_info_name_input.setText(getIntent().getStringExtra("nameinput"));
        Report_info_number.setText(R.string.number);
        Report_info_number_input.setText(getIntent().getStringExtra("numberinput"));
        Report_info_date.setText(getIntent().getStringExtra("date"));
        Report_info_date_input.setText(getIntent().getStringExtra("dateinput"));
        Report_info_phone.setText(R.string.phone);
        Report_info_phone_input.setText(getIntent().getStringExtra("phoneinput"));
//        Report_info_type.setText(getIntent().getStringExtra("type"));
//        Report_info_type_input.setText(getIntent().getStringExtra("typeinput"));
//        Report_form_time.setText(getIntent().getStringExtra("timeform"));
//        Report_form_location.setText(getIntent().getStringExtra("locationform"));
//        Report_form_detail.setText(getIntent().getStringExtra("detailform"));


    }

    public void UpdatePhoto(View view) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_select_photo, null);//获取自定义布局
        builder.setView(layout);
        final AlertDialog dlg = builder.create();
        Window window = dlg.getWindow();
        window.setGravity(Gravity.BOTTOM);
        //设置点击外围消散
        dlg.setCanceledOnTouchOutside(true);
        dlg.show();

        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); //为获取屏幕宽、高
        WindowManager.LayoutParams p = dlg.getWindow().getAttributes(); //获取对话框当前的参数值
        p.width = d.getWidth(); //宽度设置为屏幕

        window.setBackgroundDrawable(new ColorDrawable(0));

        TextView button1 = layout.findViewById(R.id.photograph);
        TextView button2 = layout.findViewById(R.id.photo);
        TextView button3 = layout.findViewById(R.id.cancel);


        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //"点击了照相";
                //  6.0之后动态申请权限 摄像头调取权限,SD卡写入权限
                if (ContextCompat.checkSelfPermission(fragment2_report.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        && ContextCompat.checkSelfPermission(fragment2_report.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(fragment2_report.this,
                            new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            MY_ADD_CASE_CALL_PHONE);
                } else {
                    try {
                        //有权限,去打开摄像头
                        takePhoto();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                dlg.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //"点击了相册");
                //  6.0之后动态申请权限 SD卡写入权限
                if (ContextCompat.checkSelfPermission(fragment2_report.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(fragment2_report.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            MY_ADD_CASE_CALL_PHONE2);

                } else {
                    choosePhoto();
                }
                dlg.dismiss();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                dlg.dismiss();
            }
        });
    }


    private void takePhoto() throws IOException {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        // 获取文件
        File file = createFileIfNeed("UserIcon.png");
        //拍照后原图回存入此路径下
        Uri uri;
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            uri = Uri.fromFile(file);
        } else {
            /**
             * 7.0 调用系统相机拍照不再允许使用Uri方式，应该替换为FileProvider
             * 并且这样可以解决MIUI系统上拍照返回size为0的情况
             */
            uri = FileProvider.getUriForFile(this, "com.example.myapplication", file);
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(intent, 1);
    }

    // 在sd卡中创建一保存图片（原图和缩略图共用的）文件夹
    private File createFileIfNeed(String fileName) throws IOException {
        String fileA = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/nbinpic";
        File fileJA = new File(fileA);
        if (!fileJA.exists()) {
            fileJA.mkdirs();
        }
        File file = new File(fileA, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
    /**
     * 打开相册
     */
    private void choosePhoto() {
        //这是打开系统默认的相册(就是你系统怎么分类,就怎么显示,首先展示分类列表)
        Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(picture, 2);
    }

    /**
     * 申请权限回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == MY_ADD_CASE_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                try {
                    takePhoto();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                //"权限拒绝");
                // TODO: 2018/12/4 这里可以给用户一个提示,请求权限被拒绝了
            }
        }


        if (requestCode == MY_ADD_CASE_CALL_PHONE2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                choosePhoto();
            } else {
                //"权限拒绝");
                // TODO: 2019/5/4 这里可以给用户一个提示,请求权限被拒绝了
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode != Activity.RESULT_CANCELED) {

            String state = Environment.getExternalStorageState();
            if (!state.equals(Environment.MEDIA_MOUNTED)) return;
            // 把原图显示到界面上
            Tiny.FileCompressOptions options = new Tiny.FileCompressOptions();
            Tiny.getInstance().source(readpic()).asFile().withOptions(options).compress(new FileWithBitmapCallback() {

                @Override
                public void callback(boolean isSuccess, Bitmap bitmap, String outfile, Throwable t) {
                    photo=ss(bitmap, outfile);
                    saveImageToServer(bitmap, outfile);
                }
            });

        } else if (requestCode == 2 && resultCode == Activity.RESULT_OK
                && null != data) {
            try {
                Uri selectedImage = data.getData();
                Tiny.FileCompressOptions options = new Tiny.FileCompressOptions();
                Tiny.getInstance().source(selectedImage).asFile().withOptions(options).compress(new FileWithBitmapCallback() {
                    @Override
                    public void callback(boolean isSuccess, Bitmap bitmap, String outfile, Throwable t) {
                        photo=ss(bitmap, outfile);
                        saveImageToServer(bitmap, outfile);
                    }
                });
            } catch (Exception e) {
                //"上传失败");
            }
        }
    }

    /**
     * 从保存原图的地址读取图片
     */
    private String readpic() {
        String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/nbinpic/" + "UserIcon.png";

        return filePath;
    }

    private void saveImageToServer(final Bitmap bitmap, String outfile) {
        File file = new File(outfile);
        // TODO: 2019.5.5  这里就可以将图片文件 file 上传到服务器,上传成功后可以将bitmap设置给你对应的图片展示
//        imageView.setImageBitmap(bitmap);
        final String base = BitmapToString(bitmap);
//        final TextView test = findViewById(R.id.test);
//         test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                test.setText(base);
//            }
//        });
//         System.out.println(base);
    }

    private String ss(final Bitmap bitmap, String outfile) {
        String base = BitmapToString(bitmap);
        return base;

    }

    public static String BitmapToString(Bitmap bitmap) {
        String des = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            byte[] buffer = out.toByteArray();
            byte[] encode = Base64.encode(buffer, Base64.DEFAULT);
            des = new String(encode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return des;
    }
}

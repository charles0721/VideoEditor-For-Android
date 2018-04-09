package com.example.cj.videoeditor.activity;

<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Point;
=======
import android.app.Activity;
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
=======
import android.app.Activity;
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
=======
import android.app.Activity;
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cj.videoeditor.Constants;
import com.example.cj.videoeditor.R;
<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
import com.example.cj.videoeditor.camera.SensorControler;
import com.example.cj.videoeditor.gpufilter.SlideGpuFilterGroup;
import com.example.cj.videoeditor.gpufilter.helper.MagicFilterType;
=======
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
=======
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
=======
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
import com.example.cj.videoeditor.widget.CameraView;
import com.example.cj.videoeditor.widget.CircularProgressView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cj on 2017/7/25.
 * desc 视频录制
 * 主要包括 音视频录制、断点续录、对焦等功能
 */

<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
public class RecordedActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, SensorControler.CameraFocusListener, SlideGpuFilterGroup.OnFilterChangeListener {

    private CameraView mCameraView;
    private CircularProgressView mCapture;
    private FocusImageView mFocus;
    private ImageView mBeautyBtn;
    private ImageView mFilterBtn;
    private ImageView mCameraChange;
    private static final int maxTime = 20000;//最长录制20s
=======
public class RecorderedActivity extends Activity implements View.OnClickListener {

    private CameraView mCameraView;
    private CircularProgressView mCapture;
    private static final int maxTime = 2000;//最长录制20s
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
=======
public class RecorderedActivity extends Activity implements View.OnClickListener {

    private CameraView mCameraView;
    private CircularProgressView mCapture;
    private static final int maxTime = 2000;//最长录制20s
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
=======
public class RecorderedActivity extends Activity implements View.OnClickListener {

    private CameraView mCameraView;
    private CircularProgressView mCapture;
    private static final int maxTime = 2000;//最长录制20s
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
    private boolean pausing = false;
    private boolean recordFlag = false;//是否正在录制

    private int WIDTH = 720,HEIGHT = 1280;

    private long timeStep = 50;//进度条刷新的时间
    long timeCount = 0;//用于记录录制时间
    private boolean autoPausing = false;
    ExecutorService executorService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorde);
        executorService = Executors.newSingleThreadExecutor();
        initView();
    }

    private void initView() {
        mCameraView = (CameraView) findViewById(R.id.camera_view);
        mCapture = (CircularProgressView) findViewById(R.id.mCapture);
<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
<<<<<<< HEAD:app/src/main/java/com/example/cj/videoeditor/activity/RecordedActivity.java
        mFocus = (FocusImageView) findViewById(R.id.focusImageView);
        mBeautyBtn = (ImageView) findViewById(R.id.btn_camera_beauty);
        mFilterBtn = (ImageView) findViewById(R.id.btn_camera_filter);
        mCameraChange = (ImageView) findViewById(R.id.btn_camera_switch);


        mBeautyBtn.setOnClickListener(this);
        mCameraView.setOnTouchListener(this);
        mCameraView.setOnFilterChangeListener(this);
        mCameraChange.setOnClickListener(this);
        mCapture.setTotal(maxTime);
        mCapture.setOnClickListener(this);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mCameraView.onTouch(event);
        if (mCameraView.getCameraId() == 1) {
            return false;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                float sRawX = event.getRawX();
                float sRawY = event.getRawY();
                float rawY = sRawY * MyApplication.screenWidth / MyApplication.screenHeight;
                float temp = sRawX;
                float rawX = rawY;
                rawY = (MyApplication.screenWidth - temp) * MyApplication.screenHeight / MyApplication.screenWidth;

                Point point = new Point((int) rawX, (int) rawY);
                mCameraView.onFocus(point, callback);
                mFocus.startFocus(new Point((int) sRawX, (int) sRawY));
        }
        return true;
    }
    Camera.AutoFocusCallback callback = new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
            //聚焦之后根据结果修改图片
            Log.e("hero","----onAutoFocus===="+success);
            if (success) {
                mFocus.onFocusSuccess();
            } else {
                //聚焦失败显示的图片
                mFocus.onFocusFailed();
=======
        mCapture.setTotal(maxTime);
        mCapture.setOnClickListener(this);
    }
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
=======
        mCapture.setTotal(maxTime);
        mCapture.setOnClickListener(this);
    }
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java
=======
        mCapture.setTotal(maxTime);
        mCapture.setOnClickListener(this);
    }
>>>>>>> parent of f6b334a... 实现视频录制，断点续录和摄像头对焦:app/src/main/java/com/example/cj/videoeditor/activity/RecorderedActivity.java

    @Override
    public void onBackPressed() {
        if (recordFlag) {
            recordFlag = false;
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCameraView.onResume();
        Toast.makeText(this,R.string.change_filter,Toast.LENGTH_SHORT).show();
        if (recordFlag && autoPausing) {
            mCameraView.resume(true);
            autoPausing = false;
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (recordFlag && !pausing) {
            mCameraView.pause(true);
            autoPausing = true;
        }
        mCameraView.onPause();
    }
    @Override
    public void onFilterChange(final MagicFilterType type) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (type == MagicFilterType.NONE){
                    Toast.makeText(RecordedActivity.this,"当前没有设置滤镜--"+type,Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RecordedActivity.this,"当前滤镜切换为--"+type,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_camera_switch:
                mCameraView.switchCamera();
                if (mCameraView.getCameraId() == 1){
                    //前置摄像头 使用美颜
                    mCameraView.changeBeautyLevel(3);
                }else {
                    //后置摄像头不使用美颜
                    mCameraView.changeBeautyLevel(0);
                }
                break;
            case R.id.mCapture:
                if (!recordFlag) {
                    executorService.execute(recordRunnable);
                } else if (!pausing) {
                    mCameraView.pause(false);
                    pausing = true;
                } else {
                    mCameraView.resume(false);
                    pausing = false;
                }
                break;
            case R.id.btn_camera_beauty:

                if (mCameraView.getCameraId() == 0){
                    Toast.makeText(this, "后置摄像头 不使用美白磨皮功能", Toast.LENGTH_SHORT).show();
                    return;
                }
                new AlertDialog.Builder(RecordedActivity.this)
                        .setSingleChoiceItems(new String[]{"关闭", "1", "2", "3", "4", "5"}, mCameraView.getBeautyLevel(),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        mCameraView.changeBeautyLevel(which);
                                        dialog.dismiss();
                                    }
                                })
                        .setNegativeButton("取消", null)
                        .show();
                break;
        }
    }
    Runnable recordRunnable = new Runnable() {
        @Override
        public void run() {
            recordFlag = true;
            pausing = false;
            autoPausing = false;
            timeCount = 0;
            long time = System.currentTimeMillis();
            String savePath = Constants.getPath("record/", time + ".mp4");

            try {
                mCameraView.setSavePath(savePath);
                mCameraView.startRecord();
                while (timeCount <= maxTime && recordFlag) {
                    if (pausing || autoPausing) {
                        continue;
                    }
                    mCapture.setProcess((int) timeCount);
                    Thread.sleep(timeStep);
                    timeCount += timeStep;
                }
                recordFlag = false;
                mCameraView.stopRecord();
                if (timeCount < 2000) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RecordedActivity.this, "录像时间太短", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    recordComplete(savePath);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private void recordComplete(final String path) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mCapture.setProcess(0);
                Toast.makeText(RecordedActivity.this, "文件保存路径：" + path, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

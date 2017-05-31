package com.example.telassimgomez.studyjam_proyectofinal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashscreenActivity extends Activity {

    private ImageView ivLogo;
    private Animation animacion;

    private SoundPool spInicio;
    private int resInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**para ocultar el toolBar**/
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_splashscreen);
        ivLogo = (ImageView) findViewById(R.id.ivLogotipo);

        animacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splashscreen);
        ivLogo.startAnimation(animacion);
        animacion.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        createSoundPool();

        if (resInicio != 0){
            spInicio.play(resInicio,1,1,0,0,1);
        }

    }

    private void createSoundPool() {
        /** **/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createNewSoundPool();
        } else {
            createOldSoundPool();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void createNewSoundPool(){
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        spInicio = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
        chargeSoundPool();
    }

    @SuppressWarnings("deprecation")
    protected void createOldSoundPool(){
        spInicio = new SoundPool(15, AudioManager.STREAM_MUSIC,0);
        chargeSoundPool();
    }

    public void chargeSoundPool() {
        resInicio = spInicio.load(getApplicationContext(),R.raw.audiointro,1);
    }

}

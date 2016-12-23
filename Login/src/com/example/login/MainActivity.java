package com.example.login;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView ivLeftHand1, ivLeftHand2, ivRightHand1, ivRightHand2,
			ivNose;
	private EditText etName, etPwd;
	private int thirtyFive, twenty;
	private int[] nose = new int[2];

	private Animation[] leftHand = new Animation[4];
	private Animation[] rightHand = new Animation[4];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ivLeftHand1 = (ImageView) findViewById(R.id.ivLeftHand1);
		ivLeftHand2 = (ImageView) findViewById(R.id.ivLeftHand2);
		ivRightHand1 = (ImageView) findViewById(R.id.ivRightHand1);
		ivRightHand2 = (ImageView) findViewById(R.id.ivRightHand2);
		ivNose = (ImageView) findViewById(R.id.ivNose);
		etName = (EditText) findViewById(R.id.etName);
		etPwd = (EditText) findViewById(R.id.etPwd);

		thirtyFive = dip2px(this, 35);
		twenty = dip2px(this, 20);

		leftHand();
		rightHand();

		etPwd.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					ivLeftHand1.startAnimation(leftHand[3]);
					ivLeftHand2.startAnimation(leftHand[1]);

					ivRightHand1.startAnimation(rightHand[3]);
					ivRightHand2.startAnimation(rightHand[1]);
				}
			}
		});
		
		
		etName.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					ivLeftHand1.startAnimation(leftHand[2]);
					ivLeftHand2.startAnimation(leftHand[0]);

					ivRightHand1.startAnimation(rightHand[2]);
					ivRightHand2.startAnimation(rightHand[0]);
				}
			}
		});
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		if (hasFocus) {
			ivNose.getLocationInWindow(nose);
		}
		super.onWindowFocusChanged(hasFocus);
	}

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	private void leftHand() {
		AnimationSet leftHand2CloseEye = new AnimationSet(true);
		leftHand2CloseEye.addAnimation(new RotateAnimation(15, 0,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f));
		leftHand2CloseEye.addAnimation(new TranslateAnimation(thirtyFive, 0,
				-twenty, 0));
		leftHand2CloseEye.setDuration(400);
		leftHand2CloseEye.setFillAfter(true);

		AnimationSet leftHand2Normal = new AnimationSet(true);
		leftHand2Normal.addAnimation(new RotateAnimation(0, 15,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f));
		leftHand2Normal.addAnimation(new TranslateAnimation(0, thirtyFive, 0,
				-twenty));
		leftHand2Normal.setDuration(400);
		leftHand2Normal.setFillAfter(true);

		AnimationSet leftHand1CloseEye = new AnimationSet(true);
		leftHand1CloseEye.addAnimation(new ScaleAnimation(0.5f, 1.0f, 0.7f,
				1.0f));
		leftHand1CloseEye.addAnimation(new TranslateAnimation(thirtyFive + 5,
				0, -twenty / 2, 0));
		leftHand1CloseEye.setDuration(400);
		leftHand1CloseEye.setFillAfter(true);

		AnimationSet leftHand1Normal = new AnimationSet(true);
		leftHand1Normal
				.addAnimation(new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.7f));
		leftHand1Normal.addAnimation(new TranslateAnimation(0, thirtyFive + 5,
				0, -twenty / 2));
		leftHand1Normal.setDuration(400);
		leftHand1Normal.setFillAfter(true);

		leftHand[0] = leftHand2CloseEye;
		leftHand[1] = leftHand2Normal;
		leftHand[2] = leftHand1CloseEye;
		leftHand[3] = leftHand1Normal;
	}

	private void rightHand() {
		AnimationSet rightHand2CloseEye = new AnimationSet(true);
		rightHand2CloseEye.addAnimation(new RotateAnimation(-15, 0,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f));
		rightHand2CloseEye.addAnimation(new TranslateAnimation(-thirtyFive, 0,
				-twenty, 0));
		rightHand2CloseEye.setDuration(400);
		rightHand2CloseEye.setFillAfter(true);

		AnimationSet rightHand2Normal = new AnimationSet(true);
		rightHand2Normal.addAnimation(new RotateAnimation(0, -15,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f));
		rightHand2Normal.addAnimation(new TranslateAnimation(0, -thirtyFive, 0,
				-twenty));
		rightHand2Normal.setDuration(400);
		rightHand2Normal.setFillAfter(true);

		AnimationSet rightHand1CloseEye = new AnimationSet(true);
		rightHand1CloseEye.addAnimation(new ScaleAnimation(0.5f, 1.0f, 0.7f,
				1.0f));
		rightHand1CloseEye.addAnimation(new TranslateAnimation(-thirtyFive + 5,
				0, -twenty / 2, 0));
		rightHand1CloseEye.setDuration(400);
		rightHand1CloseEye.setFillAfter(true);

		AnimationSet rightHand1Normal = new AnimationSet(true);
		rightHand1Normal
				.addAnimation(new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.7f));
		rightHand1Normal.addAnimation(new TranslateAnimation(0,
				-thirtyFive + 5, 0, -twenty / 2));
		rightHand1Normal.setDuration(400);
		rightHand1Normal.setFillAfter(true);

		rightHand[0] = rightHand2CloseEye;
		rightHand[1] = rightHand2Normal;
		rightHand[2] = rightHand1CloseEye;
		rightHand[3] = rightHand1Normal;
	}
}

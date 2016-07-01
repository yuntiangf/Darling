package com.darling.activity;

import com.darling.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class QuestionHomePage extends Activity {

	private Button question_test,question_wait;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question_homepage);
		
		question_test = (Button) findViewById(R.id.question_test);
		question_wait = (Button) findViewById(R.id.question_wait);
		
		question_test.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(QuestionHomePage.this,Question.class);
				startActivity(intent);
				finish();
			}
		});
		
		question_wait.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
}

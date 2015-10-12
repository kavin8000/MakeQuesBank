package com.kavinapps.androidk.makequesbank;

import android.content.DialogInterface;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    Button mButton1,mButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化 Bmob SDK，第一个参数为上下文，第二个参数为Application ID
        Bmob.initialize(this, "e9ae0dc754f7478146a81d9842991d8b");
        //按键初始化
        mButton1 = (Button)findViewById(R.id.button01);
        mButton2 = (Button)findViewById(R.id.button02);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("增加");
                Lost lost = new Lost();
                lost.setDescribe("1");
                lost.setPhone("2");
                lost.setTitle("3");
                lost.save(MainActivity.this, new SaveListener() {

                    @Override
                    public void onSuccess() {
                        showToast("失物信息添加成功!");
                        //其他代码
                    }

                    @Override
                    public void onFailure(int code, String arg0) {
                        showToast("添加失败:" + arg0);
                    }
                });
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("删除");
            }
        });

    }
    public void showToast(CharSequence text ){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
//若出现non-zero 错误；
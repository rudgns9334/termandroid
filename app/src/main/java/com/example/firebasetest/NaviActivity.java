package com.example.firebasetest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NaviActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;
    Frag3 fragment3;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instagram);
        manager = getSupportFragmentManager();

        //프래그먼트메니져로 xml에 정의된 프래그먼트 찾기
        //fragment3 =  (Frag3) manager.findFragmentById(R.id.fragment3);
        bottomNavigationView = findViewById(R.id.bottomNavi);
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        setFrag(0);
                        break;
                    case R.id.search:
                        setFrag(1);
                        break;
                    case R.id.plus:
                        setFrag(2);
                        break;
                    case R.id.star:
                        setFrag(3);
                        break;
                    case R.id.user:
                        setFrag(4);
                        break;

                }

                return true;
            }

        });
        setFrag(0);

    }


    // 프래그먼트 교체가 일어나는 실행문이다.
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, frag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame, frag5);
                ft.commit();
                break;
        }


    }

}

package layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.shunzhong.car.ClassifyActivity;
import com.shunzhong.car.CompanyActivity;
import com.shunzhong.car.LianxiActivity;
import com.shunzhong.car.R;

public class HomeFragment extends Fragment {
    public HomeFragment() {
    }
ImageButton lianxi,company,kefu,gongqiu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        lianxi = (ImageButton) view.findViewById(R.id.lianxi);
        company = (ImageButton) view.findViewById(R.id.company);
        kefu = (ImageButton) view.findViewById(R.id.kefu);
        gongqiu = (ImageButton) view.findViewById(R.id.gongqiu);

        lianxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LianxiActivity.class);
                startActivity(intent);
            }
        });
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CompanyActivity.class);
                startActivity(intent);
            }
        });
        gongqiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClassifyActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
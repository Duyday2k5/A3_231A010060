package vn.edu.vhu.ltdd.a3layout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

/**
 * Lab A3 tập trung vào XML Layout, nên phần Java chỉ làm 3 việc:
 * ánh xạ view, hiện Snackbar khi bấm Đăng nhập và mở màn hình ConstraintLayout.
 */
public class MainActivity extends AppCompatActivity {

    // TODO: thay 2201234567 bằng MSSV của bạn
    private static final String TAG = "A3_2201234567";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        // Lệnh log khi khởi tạo đã được chuyển vào nút đăng nhập bên dưới

        Button btnLogin = findViewById(R.id.btnLogin);
        CheckBox cbRemember = findViewById(R.id.cbRemember);

        btnLogin.setOnClickListener(v -> {
            boolean isLandscape = getResources().getConfiguration().orientation
                    == Configuration.ORIENTATION_LANDSCAPE;
            Log.d(TAG, "Hệ thống đã nạp layout: " + (isLandscape ? "res/layout-land" : "res/layout") + " (Đã bấm Đăng nhập)");
            
            Snackbar.make(v, getString(R.string.login_success)
                    + (cbRemember.isChecked() ? " (đã ghi nhớ)" : ""), Snackbar.LENGTH_SHORT).show();
        });

        // Bắt sự kiện chuyển sang màn hình Đăng ký
        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v -> 
                startActivity(new Intent(this, RegisterActivity.class)));
    }
}
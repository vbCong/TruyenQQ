package com.example.truyenii;

import android.accounts.Account;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DangKy2 extends AppCompatActivity {
    public static final String TAG = DangKy2.class.getSimpleName();

    private EditText edtUserName;
    private EditText edtPassWord;
    private EditText edtEmail;
    private Button btnRegister;
    private Button btnLogin;
    private ProgressDialog pDialog;

    public static final String REGISTER_URL = "localhost/android/register.php";

    public static final String KEY_USERNAME = "TenDangNhap";
    public static final String KEY_PASSWORD = "Password";
    public static final String KEY_EMAIL = "Email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get data input
                String username = edtUserName.getText().toString().trim();
                String password = edtPassWord.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();

                //Call method register
                registerUser(username, password, email);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKy2.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {

        edtUserName = (EditText) findViewById(R.id.editUsername);
        edtPassWord = (EditText) findViewById(R.id.editPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtEmail = (EditText) findViewById(R.id.editEmail);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Đang đăng ký...");
        pDialog.setCanceledOnTouchOutside(false);
    }

    /**
     * Method register
     *
     * @param username
     * @param password
     * @param email    result json
     */
    private void registerUser(final String username, final String password, final String email) {

        if (checkEditText(edtUserName) && checkEditText(edtPassWord) && checkEditText(edtEmail) && isValidEmail(email)) {
            pDialog.show();
            StringRequest registerRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d(TAG, response);
                            String message = "";
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                if (jsonObject.getInt("success") == 1) {
                                    Account account = new Account();
                                    account.setUserName(jsonObject.getString("user_name"));
                                    account.setEmail(jsonObject.getString("email"));
                                    message = jsonObject.getString("message");
                                    Toast.makeText(DangKy2.this, message, Toast.LENGTH_LONG).show();
                                    //Start LoginActivity
                                    Intent intent = new Intent(DangKy2.this, LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    message = jsonObject.getString("message");
                                    Toast.makeText(DangKy2.this, message, Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException error) {
                                VolleyLog.d(TAG, "Error: " + error.getMessage());
                            }
                            pDialog.dismiss();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            VolleyLog.d(TAG, "Error: " + error.getMessage());
                            pDialog.dismiss();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put(KEY_USERNAME, username);
                    params.put(KEY_PASSWORD, password);
                    params.put(KEY_EMAIL, email);
                    return params;
                }

            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(registerRequest);
        }
    }

    /**
     * Check Input
     */
//    private boolean checkEditText(EditText editText) {
//        if (editText.getText().toString().trim().length() > 0)
//            return true;
//        else {
//            editText.setError("Vui lòng nhập dữ liệu!");
//        }
//        return false;
//    }
//
//    /**
//     * Check Email
//     */
//    private boolean isValidEmail(String target) {
//        if (target.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+"))
//            return true;
//        else {
//            edtEmail.setError("Email sai định dạng!");
//        }
//        return false;
//    }
}

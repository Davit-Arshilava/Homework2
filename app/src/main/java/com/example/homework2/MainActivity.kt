package com.example.homework2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.FirebaseAuthKtxRegistrar
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth= FirebaseAuth.getInstance();

        if(editEmail.text.trim().toString().isNotEmpty() || editPassword.text.trim().toString().isNotEmpty()){
                createUser(editEmail.text.trim().toString(),editPassword.text.trim().toString())
            Toast.makeText(this,"input provided", Toast.LENGTH_LONG).show()
            
        }else{
            Toast.makeText(this,"input Required", Toast.LENGTH_LONG).show()
        }
    }
    fun createUser(email:String, password:String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener (this){ task ->
                if(task.isSuccessful){
                    Log.e("Task message", "Successful")
                }else{
                    Log.e("Task message", "Failed"+task.exception)
                }

            }
    }
}
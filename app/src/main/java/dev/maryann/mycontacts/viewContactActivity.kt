package dev.maryann.mycontacts
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.maryann.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtra()
    }
    fun getExtra(){
        val extras=intent.extras
        var name=intent.extras?.getString("Name","")
        var phone=intent.extras?.getString("PHONE_NUMBER","")
        var email=intent.extras?.getString("Email","")
        var address=intent.extras?.getString("Address","")
        var image=binding.imgphoto

        Toast.makeText(this,name,Toast.LENGTH_LONG).show()
        Toast.makeText(this,phone,Toast.LENGTH_LONG).show()
        binding.tvname1.text=name
        binding.tvnumber.text=phone
        binding.tvemail1.text=email
        binding.tvaddress1.text=address
        binding.tvnumber1.text=phone
        binding.tvnumber2.text=phone
        Picasso.get().load(intent.getStringExtra("Image")).into(image)

    }
}
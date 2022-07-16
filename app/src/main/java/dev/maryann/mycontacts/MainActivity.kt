package dev.maryann.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.maryann.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contacts()
    }

    fun contacts(){
        var contact1=Contact("Abby","07686989","abby@gmail.com","korongo","https://images.goojjjfgchgcgc2")
        var contact2=Contact("Ali","07686989","abby@gmail.com","korongo","https://images.unsplash.com/photo-1627897495484-229b29feb0d5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YmxhY2slMjBwZW9wbGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        var contact3=Contact("Alex","07686989","abby@gmail.com","korongo","https://images.unsplash.com/photo-1543807535-eceef0bc6599?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8YmxhY2slMjBwZW9wbGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        var contact4=Contact("Aron","07686989","abby@gmail.com","korongo","https://images.unsplash.com/photo-1614251056798-0a63eda2bb25?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTV8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact5=Contact("Asha","07686989","abby@gmail.com","korongo","https://images.unsplash.com/photo-1539701938214-0d9736e1c16b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact6=Contact("Abel","07686989","abby@gmail.com","korongo","")
        var  contactList=listOf(contact1,contact2,contact3,contact4,contact5,contact6)
        var contactAdapter=contactRvadapter(contactList)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactAdapter
    }
}
package dev.maryann.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.PicassoProvider
import dev.maryann.mycontacts.databinding.ContactListNameBinding


class ContactRvAdapter(var contactlist:List<Contact>):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder{
        var binding =ContactListNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact = contactlist.get(position)
        val contactBinding = holder.binding
        contactBinding.tvname.text = currentContact.name
        contactBinding.tvphonenumber.text = currentContact.phonenumber
        contactBinding.tvemail.text = currentContact.email
        contactBinding.tvaddress.text = currentContact.address

        Picasso.get()
            .load(currentContact.image)
            .resize(300,300)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(contactBinding. imgcontact)

        val context =holder.itemView.context
        holder.binding.imgcontact.setOnClickListener {
            Toast.makeText(context,"You have to click on the face",Toast.LENGTH_LONG).show()
        }

        contactBinding.cvcontact.setOnClickListener {
            val intent=Intent(context,ViewContactActivity::class.java)
            intent.putExtra("Name",currentContact.name)
            intent.putExtra("PHONE_NUMBER",currentContact.phonenumber)
            intent.putExtra("Number",currentContact.number)
            intent.putExtra("Email",currentContact.email)
            intent.putExtra("Address",currentContact.address)
            intent.putExtra("Image",currentContact.image)
            context.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return contactlist.size
    }
}
class ContactViewHolder(var binding:ContactListNameBinding):RecyclerView.ViewHolder(binding.root){


}
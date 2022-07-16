package dev.maryann.mycontacts

import android.content.Intent
import android.media.Image
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

class contactRvadapter (var contactList:List<Contact>): RecyclerView.Adapter<contactRvadapter.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding=ContactListNameBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
            var contact=ContactViewHolder(binding)
        return contact

    }
    override fun onBindViewHolder(holder: ContactViewHolder, position:Int) {
        var currentContact=contactList.get(position)
        holder.binding.tvName.text=currentContact.name
        holder.binding.tvnumber.text=currentContact.number
        holder.binding.tvEmail.text=currentContact.email
        holder.binding.tvAdress.text=currentContact.address
        Picasso.get()
            .load(currentContact.image)
            .placeholder(R.drawable.ic_baseline_person_24)
            .error(R.drawable.ic_baseline_error_24)
            .resize(300,300)
            .centerCrop()
            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(holder.binding.imgcontact)
        val context=holder.itemView.context
        holder.binding.imgcontact.setOnClickListener{
            Toast.makeText(context,"You have clicked on ${currentContact.name}'s image",Toast.LENGTH_SHORT).show()
            }



            holder.binding.cvContact.setOnClickListener(){
                val intent = Intent(context, viewContactActivity::class.java)
                intent.putExtra("Name",currentContact.name)
                intent.putExtra("Email",currentContact.email)
                context.startActivity(intent)
            }
    }

    override fun getItemCount(): Int {
      return contactList.size
    }


class ContactViewHolder(var binding: ContactListNameBinding):RecyclerView.ViewHolder(binding.root)
}




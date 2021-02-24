package martinamagdalenajukic.ferit.lv4zadaca;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private Context context;
    private List<Item> itemList;

    public RecyclerAdapter(List<Item> list, Context cont){
        itemList=list;
        context=cont;
    }

    public void setItemList(List<Item> listItem){
        itemList=listItem;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Glide.with(context).load(itemList.get(position).getImageLink().toString()).apply(RequestOptions.centerCropTransform()).into(holder.ivItem);
        holder.setName(itemList.get(position));
        holder.setPrice(itemList.get(position));
        holder.setRating(itemList.get(position));
        holder.setDescription(itemList.get(position));
        Log.d("recicler", itemList.get(0).getBrand());
    }

    @Override
    public int getItemCount() {
        if (itemList!=null) return itemList.size();
        else return 0;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivItem;
        private TextView tvName, tvPrice, tvRating, tvDescription;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItem=itemView.findViewById(R.id.ivItem);
            tvName=itemView.findViewById(R.id.tvName);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvRating=itemView.findViewById(R.id.tvRating);
            tvDescription=itemView.findViewById(R.id.tvDescription);
        }

        public void setImage(Item item) { ivItem.setImageURI(Uri.parse(item.getImageLink()));}
        public void setName(Item item) { tvName.setText("Name: "+item.getName().toString());}
        public void setPrice(Item item) {tvPrice.setText("Price: "+item.getPrice().toString());}
        public void setRating(Item item) {tvRating.setText(item.getRating()!=null? "Rating: "+item.getRating().toString(): "Rating: 0.0");}
        public void setDescription(Item item) {tvDescription.setText(item.getDescription().toString());}
    }
}

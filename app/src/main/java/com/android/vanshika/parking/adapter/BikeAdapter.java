package com.android.vanshika.parking.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.vanshika.parking.R;
import com.android.vanshika.parking.Vehicle;
import java.util.List;

public class BikeAdapter extends RecyclerView.Adapter <BikeAdapter.ViewHolder>{
  List<Vehicle> bikesParked;
  public BikeAdapter(List<Vehicle> bikesParked) {
    this.bikesParked=bikesParked;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.card_view, parent, false);

    return new ViewHolder(itemView);
  }

  @Override public void onBindViewHolder(final ViewHolder holder, int position) {
    Vehicle vehicle=bikesParked.get(position);
      holder.vehicleNumber.setText(vehicle.getNumber());
      holder.amount.setText(vehicle.getPayment());
      holder.time.setText(vehicle.getTime());
      holder.button.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
            holder.cardViewObject.removeView(view);
        }
      });
  }

  @Override public int getItemCount() {
    return bikesParked.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    TextView button,vehicleNumber,amount,time;
    CardView cardViewObject;
    public ViewHolder(View itemView) {
      super(itemView);
      button=itemView.findViewById(R.id.button);
      cardViewObject=itemView.findViewById(R.id.cardView);
      vehicleNumber=itemView.findViewById(R.id.vehicleNumber);
      amount=itemView.findViewById(R.id.amount);
      time=itemView.findViewById(R.id.time);
    }
  }
}
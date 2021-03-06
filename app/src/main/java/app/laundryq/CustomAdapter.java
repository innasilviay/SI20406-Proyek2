package app.laundryq;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context c;
    String[] namaToko = {"Ros Laundry", "Inna Laundry", "Daffa Laundry", "Devani Laundry"};
    String[] tanggal = {"19 Juni 2021", "20 Juni 2021", "21 Juni 2021", "22 Juni 2021"};
    double[] berat = { 2.2, 3.2, 4, 2.5};
    public String[] status = {"Dalam Proses", "Selesai", "Batal", "Selesai"};
    String[] id = {"000001", "000002", "000004", "000005"};
    String[] noPesanan = {"0002", "0003", "0123", "0122"};
    String[] parfum = {"Molto Baby", "Downy Hitam", "Downy Merah", "Molto Jasmien"};
    String[] layanan = {"Normal", "Normal", "Normal", "Normal"};
    int[] rating = {4, 4, 4, 5};


    public CustomAdapter(Context ctx) {
        this.c = ctx;
    }

    @Override
    public int getCount() {
        return namaToko.length;
    }

    @Override
    public Object getItem(int i) {
        return namaToko[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.riwayat_list_layout, null);

        TextView mNamaToko = convertView.findViewById(R.id.nama_toko);
        TextView mTanggal = convertView.findViewById(R.id.tanggal);
        TextView mBeratBiaya = convertView.findViewById(R.id.berat_biaya);
        TextView mStatus = convertView.findViewById(R.id.status);
        TextView mBiaya = convertView.findViewById(R.id.biaya);

        Double d = new Double(berat[i] * 4000);
        int biaya = d.intValue();

        mNamaToko.setText(namaToko[i]);
        mTanggal.setText(tanggal[i]);
        mBeratBiaya.setText(berat[i] + " kg");
        mBiaya.setText("Rp. " + biaya + ",-");

        mStatus.setText(status[i]);
        if (status[i] == "Dalam Proses") mStatus.setTextColor(Color.parseColor("#fdd835"));
        else if (status[i] == "Selesai") mStatus.setTextColor(Color.parseColor("#64dd17"));
        else if (status[i] == "Batal") mStatus.setTextColor(Color.parseColor("#dd2c00"));

        return convertView;
    }
}

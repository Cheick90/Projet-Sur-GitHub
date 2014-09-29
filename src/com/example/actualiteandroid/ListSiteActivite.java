package com.example.actualiteandroid;



import android.content.Context;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class ListSiteActivite extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
 
	public ListSiteActivite(Context context, String[] values) {
		super(context, R.layout.listimage, values);
		this.context = context;
		this.values = values;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.listimage, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		textView.setText(values[position]);
 
		// Change icon based on name
		String s = values[position];
 
		System.out.println(s);

		if (s.equals("Maliweb")) {
			imageView.setImageResource(R.drawable.maliweb);
		} else if (s.equals("Maliactu")) {
			imageView.setImageResource(R.drawable.maliactu1);
		} else if (s.equals("abamako")) {
			imageView.setImageResource(R.drawable.abamako);
		} else if (s.equals("Malijet")){
			imageView.setImageResource(R.drawable.malijet);
		}else if (s.equals("RFI")){
			imageView.setImageResource(R.drawable.icon_rfi);
		}else if (s.equals("Jeune Afrique")){
			imageView.setImageResource(R.drawable.jeuneafrique);
		}else if (s.equals("TV5 Monde")){
			imageView.setImageResource(R.drawable.tv5monde);
		}else if (s.equals("EURONEWS")){
			imageView.setImageResource(R.drawable.eronews);
		}else if (s.equals("Le FIGARO")){
			imageView.setImageResource(R.drawable.icon_figaro);
		}else if (s.equals("Le POINT")){
			imageView.setImageResource(R.drawable.le_point);
		}else if (s.equals("BAMADA")){
			imageView.setImageResource(R.drawable.bamada);
		}else if (s.equals("FRANCE24")){
			imageView.setImageResource(R.drawable.france24);
		}
 
		return rowView;
	}
}

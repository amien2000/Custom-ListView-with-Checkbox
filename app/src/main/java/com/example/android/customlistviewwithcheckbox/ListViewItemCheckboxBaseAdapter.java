package com.example.android.customlistviewwithcheckbox;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

//import com.dev2qa.example.R;

import java.util.List;

/**
 * Created by Jerry on 1/21/2018.
 */

public class ListViewItemCheckboxBaseAdapter extends BaseAdapter {
    private static final String TAG = ListViewItemCheckboxBaseAdapter.class.getSimpleName();

    private List<ListViewItemDTO> listViewItemDtoList = null;

    private Context ctx = null;

    public ListViewItemCheckboxBaseAdapter(Context ctx, List<ListViewItemDTO> listViewItemDtoList) {
        this.ctx = ctx;
        this.listViewItemDtoList = listViewItemDtoList;
    }

    @Override
    public int getCount() {
        int ret = 0;
        if(listViewItemDtoList!=null)
        {
            ret = listViewItemDtoList.size();
            Log.i(TAG,"XXX getCount() --->"+ret);
        }
        return ret;
    }

    @Override
    public Object getItem(int itemIndex) {
        Object ret = null;
        if(listViewItemDtoList!=null) {
            ret = listViewItemDtoList.get(itemIndex);
            Log.i(TAG,"XXX getItem() --->"+((ListViewItemDTO) ret).getItemText());
        }
        return ret;
    }

    @Override
    public long getItemId(int itemIndex) {
        Log.i(TAG,"XXX getItemId() --->"+itemIndex);
        return itemIndex;
    }

    @Override
    public View getView(int itemIndex, View convertView, ViewGroup viewGroup) {

        Log.i(TAG,"XXX getView()");
        Log.i(TAG,"XXX itemIndex "+itemIndex);


        String getText=null;

        ListViewItemViewHolder viewHolder = null;



        if(convertView!=null)
        {
            Log.i(TAG,"XXX ConvertView != null");
            viewHolder = (ListViewItemViewHolder) convertView.getTag();
            Log.i(TAG,"XXX convertView.getTag() "+convertView.getTag().toString());
            Log.i(TAG,"XXX viewHolder "+viewHolder.toString());

        }else
        {
            convertView = View.inflate(ctx, R.layout.activity_list_view_with_checkbox_item, null);
            Log.i(TAG,"XXX Inflate Only");

            CheckBox listItemCheckbox = convertView.findViewById(R.id.list_view_item_checkbox);

            TextView listItemText = convertView.findViewById(R.id.list_view_item_text);

            viewHolder = new ListViewItemViewHolder(convertView);

            viewHolder.setItemCheckbox(listItemCheckbox);

            viewHolder.setItemTextView(listItemText);

            convertView.setTag(viewHolder);
        }



        ListViewItemDTO listViewItemDto = listViewItemDtoList.get(itemIndex);

        viewHolder.getItemCheckbox().setChecked(listViewItemDto.isChecked());
        viewHolder.getItemTextView().setText(listViewItemDto.getItemText());

        getText = viewHolder.getItemTextView().getText().toString();

        Log.i(TAG,"XXX Assign to TextView --->"+getText);

        return convertView;
    }
}
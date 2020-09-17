package anakar01.packag.com.myroster;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static java.security.AccessController.getContext;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.Viewholder> {

    private List<ModelClass> modelClassList;
    String empname;
    String empemail;
    String empmobile;
    Context context;

    public RvAdapter(Context context) {
        this.context = context;
    }

    public RvAdapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public RvAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emp_list_layout,parent, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RvAdapter.Viewholder holder, final int position) {
        empname = modelClassList.get(position).getEmpName();
        empemail = modelClassList.get(position).getEmpEmail();
        empmobile = modelClassList.get(position).getEmmMobile();
        holder.setData(empname,empemail,empmobile);

        boolean isExpanded = modelClassList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        /*try{
        holder.rv_MainLayout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(context, EditEmployee.class);
                intent.putExtra("empName", empname);
                intent.putExtra("empEmail", empemail);
                intent.putExtra("empMobile", empmobile);
                context.startActivity(intent);
            }
        });} catch (Exception e){
            Toast.makeText(context.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }*/

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView email;
        private TextView mobile;
        ConstraintLayout expandableLayout;



        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_EmpName);
            email = itemView.findViewById(R.id.tv_EmpEmail);
            mobile = itemView.findViewById(R.id.tv_EmpMobile);
            //rv_MainLayout = itemView.findViewById(R.id.rvMainLayout);

            expandableLayout= itemView.findViewById(R.id.expandableLayout);

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ModelClass modelClass = modelClassList.get(getAdapterPosition());
                    modelClass.setExpanded(!modelClass.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }

        private void setData(String empname, String empemail, String empmobile){
            name.setText(empname);
            email.setText(empemail);
            mobile.setText(empmobile);



        }
    }





}

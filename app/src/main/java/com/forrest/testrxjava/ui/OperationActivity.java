package com.forrest.testrxjava.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forrest.testrxjava.R;
import com.forrest.testrxjava.adapter.MainAdapter;
import com.forrest.testrxjava.operation.BufferOperation;
import com.forrest.testrxjava.operation.CastOperation;
import com.forrest.testrxjava.operation.CombineLatestOperation;
import com.forrest.testrxjava.operation.CreateOperation;
import com.forrest.testrxjava.operation.DebounceOperation;
import com.forrest.testrxjava.operation.DeferOperation;
import com.forrest.testrxjava.operation.DistinctOperation;
import com.forrest.testrxjava.operation.FilterOperation;
import com.forrest.testrxjava.operation.FlagMapOperation;
import com.forrest.testrxjava.operation.FromOperation;
import com.forrest.testrxjava.operation.GroupByOperation;
import com.forrest.testrxjava.operation.IOperation;
import com.forrest.testrxjava.operation.IntervalOperation;
import com.forrest.testrxjava.operation.JoinOperation;
import com.forrest.testrxjava.operation.JustOperation;
import com.forrest.testrxjava.operation.MapOperation;
import com.forrest.testrxjava.operation.MergeOperation;
import com.forrest.testrxjava.operation.RangeOperation;
import com.forrest.testrxjava.operation.RepeatOperation;
import com.forrest.testrxjava.operation.RetryOperation;
import com.forrest.testrxjava.operation.SampleOperation;
import com.forrest.testrxjava.operation.ScanOperation;
import com.forrest.testrxjava.operation.SkipOperation;
import com.forrest.testrxjava.operation.StartWithOperation;
import com.forrest.testrxjava.operation.SubscribeOperation;
import com.forrest.testrxjava.operation.SubscriptionManager;
import com.forrest.testrxjava.operation.SwitchOnNextOperation;
import com.forrest.testrxjava.operation.TakeOperation;
import com.forrest.testrxjava.operation.TimerOperation;
import com.forrest.testrxjava.operation.WindowOperation;
import com.forrest.testrxjava.operation.ZipOperation;
import com.forrest.testrxjava.view.DividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OperationActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.id_recyclerview) RecyclerView recyclerView;

    private String[] operationArray={"create","just","from","map","Subscribe","scan","retry","Debounce",
            "IntervalOperation","DeferOperation","RangeOperation","RepeatOperation",
            "BufferOperation","flagmap","GroupByOperation","TakeOperation","WindowOperation",
            "DistinctOperation","ZipOperation","TimerOperation","CastOperation","FilterOperation","SampleOperation","SkipOperation"
            ,"StartWithOperation","CombineLatestOperation","JoinOperation","MergeOperation","SwitchOnNextOperation"};
    private IOperation[] operations=new IOperation[operationArray.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        initView();
        initOperation();
    }

    private void initOperation(){
        operations[0]=new CreateOperation();
        operations[1]=new JustOperation();
        operations[2]=new FromOperation();
        operations[3]=new MapOperation();
        operations[4]=new SubscribeOperation(getWindow().getDecorView());
        operations[5]=new ScanOperation();
        operations[6]=new RetryOperation();
        operations[7]=new DebounceOperation();
        operations[8]=new IntervalOperation();
        operations[9]=new DeferOperation();
        operations[10]=new RangeOperation();
        operations[11]=new RepeatOperation();
        operations[12]=new BufferOperation();
        operations[13]=new FlagMapOperation();
        operations[14]=new GroupByOperation();
        operations[15]=new TakeOperation();
        operations[16]=new WindowOperation();
        operations[17]=new DistinctOperation();
        operations[18]=new ZipOperation();
        operations[19]=new TimerOperation();
        operations[20]=new CastOperation();
        operations[21]=new FilterOperation();
        operations[22]=new SampleOperation();
        operations[23]=new SkipOperation();
        operations[24]=new StartWithOperation();
        operations[25]=new CombineLatestOperation();
        operations[26]=new JoinOperation();
        operations[27]=new MergeOperation();
        operations[28]=new SwitchOnNextOperation();


    }

    private void initView(){
        ButterKnife.bind(this);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(
                this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(new MainAdapter(this,this,operationArray));
    }

    @Override
    protected void onStop() {
        super.onStop();
        SubscriptionManager.unSubscription();
    }

    @Override
    public void onClick(final View v) {
        if(v.getTag() instanceof Integer){
            operations[(int) v.getTag()].exeCute();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

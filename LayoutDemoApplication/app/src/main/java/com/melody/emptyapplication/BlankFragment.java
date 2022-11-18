package com.melody.emptyapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "BlankFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 在片段已与 Activity 关联时进行调用
     *
     * @param context
     */
    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        Log.d(TAG + " LifeCycle", "onAttach");
    }

    /**
     * 常用
     * 系统会在创建片段时调用此方法。当片段经历暂停或停止状态继而恢复后，如果您希望保留此片段的基本组件，则应在您的实现中将其初始化。
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG + " LifeCycle", "onCreate");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * 常用
     * 调用它可创建与片段关联的视图层次结构。
     * 系统会在片段首次绘制其界面时调用此方法。如要为您的片段绘制界面，您从此方法中返回的 View 必须是片段布局的根视图。如果片段未提供界面，您可以返回 null。
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.d(TAG + " LifeCycle", "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    /**
     * 废弃
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        Log.d(TAG + " LifeCycle", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);

        Button changeBtn = this.getActivity().findViewById(R.id.blankfragmentBtn);
        TextView txtView = this.getActivity().findViewById(R.id.blankfragmentTitle);

        if (changeBtn != null) {
            changeBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtView.setText(R.string.new_blank_fragment);
                }
            });
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG + " LifeCycle", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG + " LifeCycle", "onResume");
    }

    /**
     * 常用
     * 系统会将此方法作为用户离开片段的第一个信号（但并不总是意味着此片段会被销毁）进行调用。
     * 通常，您应在此方法内确认在当前用户会话结束后仍然有效的任何更改（因为用户可能不会返回）。
     */
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG + " LifeCycle", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG + " LifeCycle", "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG + " LifeCycle", "onDestroy");
    }

    /**
     * 在移除与片段关联的视图层次结构时进行调用。
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG + " LifeCycle", "onDestroyView");
    }

    /**
     * 在取消片段与 Activity 的关联时进行调用。
     */
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG + " LifeCycle", "onDetach");
    }
}
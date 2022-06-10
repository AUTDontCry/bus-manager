package at.wifi.swdev.saschabrodschneider.view.Model;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Application application;

    public ViewModelFactory(Application application){
        this.application = application;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull  Class<T> modelClass) {

        if(modelClass == DienstViewModel.class){
            return (T) new DienstViewModel(application);

        }else if (modelClass == DienstTagViewModel.class){
            return (T) new DienstTagViewModel(application);

        }else if(modelClass == HaltestellenZeitViewModel.class){
            return (T) new HaltestellenZeitViewModel(application);

        }else if(modelClass == HaltestelleViewModel.class){
            return (T) new HaltestelleViewModel(application);

        }else if (modelClass == KursnummerViewModel.class){
            return (T) new KursnummerViewModel(application);

        }else if(modelClass == ZielschildnummerViewModel.class){
            return (T) new ZielschildnummerViewModel(application);
        }


        return super.create(modelClass);
    }
}

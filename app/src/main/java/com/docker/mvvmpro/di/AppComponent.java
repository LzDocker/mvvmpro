/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.docker.mvvmpro.di;



import com.docker.common.di.ApiModule;
import com.docker.mvvmpro.DockerApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        ApiModule.class,
        AppModule.class,
        ViewModelModule.class,
        UIModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        Builder apiModule(ApiModule apiModule);
        Builder appModule(AppModule appModule);

        AppComponent build();
    }

    void inject(DockerApp app);

}

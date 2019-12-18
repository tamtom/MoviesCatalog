# MoviesCatalog 🎥
 Android application following best practices: Kotlin, coroutines, Clean Architecture, tests, MVVM, Room

[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

MoviesCatalog is an Android app for list movies

It displays the most popular  movies, top rated, top revenue 

<br>


## Android development

MoviesCatalog attempts to make use of the latest Android libraries and best practices:
* Entirely written in [Kotlin](https://kotlinlang.org/) (including [coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)) with [ktlint](https://github.com/pinterest/ktlint) for code style
* Makes use of [Android Jetpack](https://developer.android.com/jetpack/), including:
  * All appropriate [Architecture Components](https://developer.android.com/jetpack/arch/), including **Lifecycles**, **Navigation** , **LiveData** , **Room**
  * MVVM Architecture
  * [ConstraintLayout](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout) 2.0.
  * [Android KTX](https://developer.android.com/kotlin/ktx) for more fluent use of Android APIs
* [Retrofit](https://square.github.io/retrofit/)/[OkHttp](https://square.github.io/okhttp/) for networking
* [coil](https://github.com/coil-kt/coil) for image loading
* [Dagger2](https://google.github.io/dagger/) for dependency injection
* Fully Testable using [mockito](https://github.com/nhaarman/mockito-kotlin) 

## License

```
Copyright 2019 Omar Tamimi

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```

# 📘 دليل المطور

دليل شامل لتطوير تطبيق Lmar Vet ProFarm

---

## 📦 المتطلبات

### أدوات التطوير
- **Android Studio:** 4.2 أو أحدث
- **JDK:** 11 أو أحدث
- **Gradle:** 7.0 أو أحدث
- **Git:** 2.30 أو أحدث

### المتطلبات الإضافية
- محاكي Android أو جهاز حقيقي
- اتصال إنترنت لتحميل المكتبات

---

## 🚀 إعداد بيئة التطوير

### 1. استنساخ المشروع
```bash
git clone https://github.com/vetdaifhaidar-cmd/-.git
cd -
```

### 2. فتح في Android Studio
```bash
# الطريقة 1
android-studio .

# الطريقة 2: افتح Android Studio ثم اختر Open > اختر المشروع
```

### 3. الانتظار لتنزيل المكتبات
المرة الأولى قد تستغرق وقتاً لتنزيل Gradle والمكتبات.

### 4. تشغيل المشروع
```bash
# الطريقة 1: من Android Studio - اضغط Run
# الطريقة 2: من Terminal
./gradlew assembleDebug
```

---

## 🏗️ هيكل المشروع

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/lmarvet/profarm/
│   │   │   ├── MainActivity.kt          # الشاشة الرئيسية
│   │   │   │
│   │   │   ├── ui/                      # طبقة المستخدم
│   │   │   │   ├── activities/          # الأنشطة الرئيسية
│   │   │   │   ├── fragments/           # الشاشات الفرعية
│   │   │   │   ├── components/          # المكونات القابلة لإعادة الاستخدام
│   │   │   │   └── theme/               # المظهر والألوان
│   │   │   │
│   │   │   ├── viewmodels/              # ViewModel (منطق الأعمال)
│   │   │   │   ├── FarmViewModel.kt
│   │   │   │   ├── HealthViewModel.kt
│   │   │   │   └── ReportViewModel.kt
│   │   │   │
│   │   │   ├── models/                  # نماذج البيانات
│   │   │   │   ├── Farm.kt
│   │   │   │   ├── Flock.kt
│   │   │   │   ├── Disease.kt
│   │   │   │   └── Report.kt
│   │   │   │
│   │   │   ├── repository/              # الوصول للبيانات
│   │   │   │   ├── FarmRepository.kt
│   │   │   │   ├── HealthRepository.kt
│   │   │   │   └── ReportRepository.kt
│   │   │   │
│   │   │   ├── database/                # قاعدة البيانات المحلية
│   │   │   │   ├── AppDatabase.kt
│   │   │   │   ├── dao/
│   │   │   │   │   ├── FarmDao.kt
│   │   │   │   │   ├── FlockDao.kt
│   │   │   │   │   └── ReportDao.kt
│   │   │   │   └── entities/
│   │   │   │
│   │   │   ├── network/                 # الاتصال بالإنترنت
│   │   │   │   ├── ApiService.kt
│   │   │   │   ├── interceptors/
│   │   │   │   └── models/
│   │   │   │
│   │   │   ├── utils/                   # الأدوات المساعدة
│   │   │   │   ├── Constants.kt
│   │   │   │   ├── Extensions.kt
│   │   │   │   └── Validators.kt
│   │   │   │
│   │   │   └── di/                      # Dependency Injection (Dagger/Hilt)
│   │   │       └── AppModule.kt
│   │   │
│   │   ├── res/
│   │   │   ├── layout/                  # XML layouts
│   │   │   ├── drawable/                # الصور والرسومات
│   │   │   ├── values/
│   │   │   │   ├── colors.xml
│   │   │   │   ├── strings.xml
│   │   │   │   ├── dimens.xml
│   │   │   │   └── styles.xml
│   │   │   ├── mipmap/                  # أيقونات التطبيق
│   │   │   └── menu/                    # قوائم التطبيق
│   │   │
│   │   └── AndroidManifest.xml
│   │
│   └── test/                            # الاختبارات
│       ├── java/com/lmarvet/profarm/
│       │   ├── unit/
│       │   └── integration/
│       └── resources/
│
├── build.gradle
├── proguard-rules.pro
└── src/androidTest/                     # اختبارات UI
```

---

## 🔧 المكتبات الرئيسية

### Architecture & Framework
```gradle
// Jetpack
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.6.1'

// Compose (اختياري)
implementation 'androidx.compose.ui:ui:1.5.0'

// ViewModel
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1'
```

### Database
```gradle
// Room
implementation 'androidx.room:room-runtime:2.5.2'
implementation 'androidx.room:room-ktx:2.5.2'
kapt 'androidx.room:room-compiler:2.5.2'

// Datastore
implementation 'androidx.datastore:datastore-preferences:1.0.0'
```

### Networking
```gradle
// Retrofit
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

// OkHttp
implementation 'com.squareup.okhttp3:okhttp:4.11.0'
implementation 'com.squareup.okhttp3:logging-interceptor:4.11.0'
```

### Asynchronous
```gradle
// Coroutines
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1'
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1'
```

### Dependency Injection
```gradle
// Hilt
implementation 'com.google.dagger:hilt-android:2.46'
kapt 'com.google.dagger:hilt-compiler:2.46'
```

### UI
```gradle
// Material Design
implementation 'com.google.android.material:material:1.9.0'

// Glide (للصور)
implementation 'com.github.bumptech.glide:glide:4.15.1'
kapt 'com.github.bumptech.glide:compiler:4.15.1'
```

### Testing
```gradle
// JUnit
testImplementation 'junit:junit:4.13.2'

// Mockito
testImplementation 'org.mockito.kotlin:mockito-kotlin:5.0.0'

// Espresso
androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
```

### Firebase (اختياري)
```gradle
// Firebase
implementation 'com.google.firebase:firebase-database-ktx:20.2.2'
implementation 'com.google.firebase:firebase-auth-ktx:22.1.1'
```

---

## 💻 أمثلة الكود

### إنشاء ViewModel
```kotlin
@HiltViewModel
class FarmViewModel @Inject constructor(
    private val farmRepository: FarmRepository
) : ViewModel() {
    
    private val _farms = MutableLiveData<List<Farm>>()
    val farms: LiveData<List<Farm>> = _farms
    
    fun loadFarms() {
        viewModelScope.launch {
            try {
                val farmList = farmRepository.getAllFarms()
                _farms.value = farmList
            } catch (e: Exception) {
                // معالجة الخطأ
            }
        }
    }
}
```

### إنشاء Repository
```kotlin
class FarmRepository @Inject constructor(
    private val farmDao: FarmDao,
    private val apiService: ApiService
) {
    
    suspend fun getAllFarms(): List<Farm> {
        return farmDao.getAllFarms()
    }
    
    suspend fun addFarm(farm: Farm) {
        farmDao.insert(farm)
        // مزامنة مع الخادم
        apiService.addFarm(farm)
    }
}
```

### إنشاء Room Entity
```kotlin
@Entity(tableName = "farms")
data class Farm(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val location: String,
    val capacity: Int,
    val createdAt: Long = System.currentTimeMillis()
)
```

### إنشاء DAO
```kotlin
@Dao
interface FarmDao {
    
    @Query("SELECT * FROM farms")
    suspend fun getAllFarms(): List<Farm>
    
    @Query("SELECT * FROM farms WHERE id = :farmId")
    suspend fun getFarmById(farmId: Int): Farm
    
    @Insert
    suspend fun insert(farm: Farm)
    
    @Update
    suspend fun update(farm: Farm)
    
    @Delete
    suspend fun delete(farm: Farm)
}
```

---

## 🧪 الاختبارات

### Unit Tests
```kotlin
class FarmViewModelTest {
    
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    
    private lateinit var viewModel: FarmViewModel
    private val mockRepository = mock<FarmRepository>()
    
    @Before
    fun setup() {
        viewModel = FarmViewModel(mockRepository)
    }
    
    @Test
    fun testLoadFarms() {
        val testFarms = listOf(
            Farm(1, "Farm 1", "Location 1", 1000)
        )
        
        `when`(mockRepository.getAllFarms()).thenReturn(testFarms)
        
        viewModel.loadFarms()
        
        assertEquals(testFarms, viewModel.farms.value)
    }
}
```

### تشغيل الاختبارات
```bash
# اختبارات Unit
./gradlew test

# اختبارات UI
./gradlew connectedAndroidTest

# مع التقرير
./gradlew test --info
```

---

## 🐛 تصحيح الأخطاء (Debugging)

### استخدام Android Studio Debugger
```kotlin
// ضع Breakpoint على السطر وشغل التطبيق في Debug mode
// اضغط على Step Over/Into/Out للتحرك بين الأسطر
```

### Logging
```kotlin
// استخدم Timber أو Log
Log.d("FarmViewModel", "Farms loaded: ${farms.value}")

// أو مع Timber
Timber.d("Farms loaded: %s", farms.value)
```

### Android Profiler
- افتح Android Studio
- اذهب إلى View > Tool Windows > Profiler
- راقب CPU, Memory, Network

---

## 📝 معايير الكود

### Kotlin Style Guide
```kotlin
// صحيح ✅
class FarmManager(
    private val repository: FarmRepository
) {
    fun manageFarm(farm: Farm) {
        // التنفيذ
    }
}

// خطأ ❌
class farm_manager(
    val repo: FarmRepository
) {
    fun manage_farm(f: Farm) {
        // التنفيذ
    }
}
```

### Documentation
```kotlin
/**
 * يدير عمليات المزرعة الرئيسية.
 *
 * @param farm بيانات المزرعة
 * @return نتيجة العملية
 * @throws IllegalArgumentException إذا كانت البيانات غير صحيحة
 */
fun manageFarm(farm: Farm): Result {
    // التنفيذ
}
```

---

## 🚢 البناء والنشر

### Build APK
```bash
# Debug APK
./gradlew assembleDebug

# Release APK
./gradlew assembleRelease

# APK موجود في: app/build/outputs/apk/
```

### Build Bundle
```bash
./gradlew bundleRelease

# Bundle موجود في: app/build/outputs/bundle/
```

---

## 📖 مراجع مفيدة

- [Android Developer Documentation](https://developer.android.com/)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [MVVM Architecture](https://developer.android.com/jetpack/guide)
- [Room Database](https://developer.android.com/training/data-storage/room)
- [Retrofit](https://square.github.io/retrofit/)

---

**للأسئلة والدعم: info@lmarvet.com**


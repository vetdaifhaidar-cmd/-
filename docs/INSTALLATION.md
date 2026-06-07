# 🔧 دليل التثبيت - Lmar Vet ProFarm

## متطلبات النظام

### للتطوير
- **Android Studio:** 4.2 أو أحدث
- **JDK:** 11 أو أحدث
- **Gradle:** 7.0 أو أحدث
- **RAM:** 8GB على الأقل (للتطوير)

### لتشغيل التطبيق
- **نظام التشغيل:** Android 9.0 (API 28) أو أحدث
- **RAM:** 2GB على الأقل
- **التخزين:** 100MB فارغة

---

## ✅ خطوات التثبيت

### 1️⃣ استنساخ المستودع

```bash
# فتح Terminal أو Command Prompt
git clone https://github.com/vetdaifhaidar-cmd/-.git

# الدخول للمشروع
cd -
```

### 2️⃣ فتح المشروع في Android Studio

```bash
# الطريقة 1: من Terminal
android-studio .

# الطريقة 2: من Android Studio
# File > Open > اختر مجلد المشروع
```

### 3️⃣ انتظار تحميل Gradle

- يمكن أن يستغرق وقتاً على المرة الأولى
- تأكد من وجود اتصال إنترنت
- لا تغلق Android Studio أثناء الحمل

### 4️⃣ تنزيل SDK

إذا لم يكن لديك الـ SDK المطلوب:
```
Tools > SDK Manager > 
اختر Android 9.0 (API 28) أو أحدث > Install
```

### 5️⃣ إعداد محاكي (Emulator)

```
Tools > Device Manager > Create Device >
اختر Pixel 4 أو أي جهاز آخر >
اختر Android 9.0 أو أحدث > Create
```

### 6️⃣ تشغيل التطبيق

```bash
# الطريقة 1: من Android Studio
اضغط زر Run الأخضر (▶)

# الطريقة 2: من Terminal
./gradlew assembleDebug
```

---

## 🔐 إعداد Firebase (اختياري)

### 1. إنشاء مشروع Firebase
- افتح [Firebase Console](https://console.firebase.google.com/)
- اضغط "Create Project"
- أدخل اسم المشروع
- اختر "Create"

### 2. إضافة تطبيق Android
- في Firebase Console، اضغط Android icon
- أدخل معلومات التطبيق:
  - **Package name:** com.lmarvet.profarm
  - **App nickname:** Lmar Vet ProFarm
- اضغط "Register app"

### 3. تحميل google-services.json
- حمّل الملف من Firebase
- ضعه في: `app/google-services.json`

### 4. تفعيل Firebase في build.gradle

```gradle
// في build.gradle الجذر
plugins {
    id 'com.google.gms.google-services' version '4.3.15' apply false
}

// في app/build.gradle
plugins {
    id 'com.google.gms.google-services'
}

dependencies {
    implementation 'com.google.firebase:firebase-database-ktx:20.2.2'
    implementation 'com.google.firebase:firebase-auth-ktx:22.1.1'
}
```

---

## 🛠️ معالجة المشاكل الشائعة

### ❌ "gradle: command not found"
```bash
# تأكد من وجود Gradle أو استخدم
./gradlew --version
```

### ❌ "SDK location not found"
```
File > Project Structure > 
SDK Location > اختر Android SDK
```

### ❌ "Cannot find Emulator"
```
Tool > Device Manager > 
Create Device > اختر جهاز > Create
```

### ❌ "Compilation Error"
```bash
# نظف المشروع
./gradlew clean

# أعد بناء المشروع
./gradlew build
```

### ❌ "Gradle sync failed"
```bash
# تحديث Gradle
./gradlew wrapper --gradle-version 7.5

# أعد المحاولة
./gradlew clean
```

---

## 📦 بناء النسخ

### APK للاختبار
```bash
./gradlew assembleDebug
# النتيجة: app/build/outputs/apk/debug/app-debug.apk
```

### APK للإصدار
```bash
./gradlew assembleRelease
# النتيجة: app/build/outputs/apk/release/app-release.apk
```

### Android App Bundle
```bash
./gradlew bundleRelease
# النتيجة: app/build/outputs/bundle/release/app-release.aab
```

---

## 🧪 تشغيل الاختبارات

```bash
# اختبارات Unit
./gradlew test

# اختبارات UI
./gradlew connectedAndroidTest

# مع التقرير
./gradlew jacocoTestReport
```

---

## 📝 ملاحظات مهمة

1. **الأذونات:** التطبيق يطلب أذونات:
   - Internet
   - Camera
   - Storage
   - Location

2. **البيانات:** يتم حفظ البيانات محلياً في SQLite

3. **المزامنة:** يتم مزامنة البيانات مع Firebase (عند التفعيل)

4. **النسخ الاحتياطية:** يتم حفظ نسخ احتياطية تلقائياً

---

## 🆘 الدعم الفني

- **البريد:** info@lmarvet.com
- **الموقع:** www.lmarvet.com
- **الهاتف:** +966 XX XXX XXXX

---

**تم تحديثه:** 7 يونيو 2026


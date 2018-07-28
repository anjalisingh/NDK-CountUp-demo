#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint

JNICALL
Java_com_test_ndkcountupdemo_MainActivity_countFromJNI(
        JNIEnv *env,
        jobject,
        jint currentCount) {
    int newCount = currentCount + 1;
    return newCount;
}

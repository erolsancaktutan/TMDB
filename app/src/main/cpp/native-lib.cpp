#include <jni.h>
#include <string>

extern "C" jstring
Java_com_es_tmdb_utility_Constants_getBaseURL(JNIEnv *env, jobject thiz) {
    std::string baseUrl = "https://api.themoviedb.org/3/";
    return env->NewStringUTF(baseUrl.c_str());
}

extern "C" jstring
Java_com_es_tmdb_utility_Constants_getApiKey(JNIEnv *env, jobject thiz) {
    std::string apiKey = "8cf2487724ba50d5d082f65817908e1d";
    return env->NewStringUTF(apiKey.c_str());
}

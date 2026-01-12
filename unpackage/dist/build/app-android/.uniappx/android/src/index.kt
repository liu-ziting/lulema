@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.UNIE765849;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.appframe.AppConfig;
import io.dcloud.uniapp.extapi.exit as uni_exit;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
var firstBackTime: Number = 0;
open class GenApp : BaseApp {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLaunch(fun(_: OnLaunchOptions) {
            console.log("App Launch", " at App.uvue:5");
        }
        , instance);
        onAppShow(fun(_: OnShowOptions) {
            console.log("App Show", " at App.uvue:8");
        }
        , instance);
        onHide(fun() {
            console.log("App Hide", " at App.uvue:11");
        }
        , instance);
        onLastPageBackPress(fun() {
            console.log("App LastPageBackPress", " at App.uvue:15");
            if (firstBackTime == 0) {
                uni_showToast(ShowToastOptions(title = "再按一次退出应用", position = "bottom"));
                firstBackTime = Date.now();
                setTimeout(fun(){
                    firstBackTime = 0;
                }, 2000);
            } else if (Date.now() - firstBackTime < 2000) {
                firstBackTime = Date.now();
                uni_exit(null);
            }
        }
        , instance);
        onExit(fun() {
            console.log("App Exit", " at App.uvue:32");
        }
        , instance);
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("uni-row" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "uni-column" to padStyleMapOf(utsMapOf("flexDirection" to "column")));
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "app", name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = utsArrayOf(), emits = Map(), components = Map(), styles = GenApp.styles);
}
, fun(instance): GenApp {
    return GenApp(instance);
}
);
open class CheckInRecord (
    @JsonNotNull
    open var timestamp: Number,
    @JsonNotNull
    open var reason: String,
) : UTSObject()
val GenPagesIndexIndexClass = CreateVueComponent(GenPagesIndexIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexIndex.inheritAttrs, inject = GenPagesIndexIndex.inject, props = GenPagesIndexIndex.props, propsNeedCastKeys = GenPagesIndexIndex.propsNeedCastKeys, emits = GenPagesIndexIndex.emits, components = GenPagesIndexIndex.components, styles = GenPagesIndexIndex.styles);
}
, fun(instance): GenPagesIndexIndex {
    return GenPagesIndexIndex(instance);
}
);
open class AiAnalysisResult (
    @JsonNotNull
    open var content: String,
    @JsonNotNull
    open var success: Boolean = false,
) : UTSObject()
open class AiCheckInInput (
    @JsonNotNull
    open var timestamp: Number,
    @JsonNotNull
    open var reason: String,
) : UTSObject()
val analyzeCheckIns = fun(records: UTSArray<Any>): UTSPromise<AiAnalysisResult> {
    return UTSPromise(fun(resolve, reject){
        var promptData = "我最近的打卡记录如下：\n";
        val recentRecords = records.slice(-20);
        recentRecords.forEach(fun(item, index){
            var ts: Number = 0;
            var r: String = "";
            if (item is UTSJSONObject) {
                ts = item.getNumber("timestamp");
                r = item.getString("reason");
            } else {
                val record = item as AiCheckInInput;
                ts = record.timestamp;
                r = record.reason;
            }
            val date = Date(ts);
            val dateStr = "" + (date.getMonth() + 1) + "\u6708" + date.getDate() + "\u65E5 " + date.getHours() + ":" + date.getMinutes();
            val reason = if (r == "") {
                "未记录原因";
            } else {
                r;
            }
            ;
            promptData += "" + (index + 1) + ". \u65F6\u95F4\uFF1A" + dateStr + "\uFF0C\u539F\u56E0\uFF1A" + reason + "\n";
        }
        );
        promptData += "\n\u8BF7\u626E\u6F14\u4E00\u4F4D\u65E2\u5E7D\u9ED8\u53C8\u7280\u5229\u7684\u201C\u6212\u8272\u635F\u53CB\u201D\u517C\u201C\u91D1\u724C\u6559\u7EC3\u201D\u3002\u8BF7\u6839\u636E\u6211\u7684\u8BB0\u5F55\uFF0C\u7528\u201C\u4F60\u603B\u662F\u5728...\u7136\u540E...\u6700\u540E...\u201D\u7684\u53D9\u8FF0\u98CE\u683C\u6765\u5206\u6790\u6211\u7684\u884C\u4E3A\u6A21\u5F0F\u3002\n\u5177\u4F53\u8981\u6C42\uFF1A\n1. \u{1F575}\uFE0F \u89C4\u5F8B\u63ED\u79D8\uFF1A\u7528\u201C\u6211\u770B\u51FA\u6765\u4E86\uFF0C\u4F60\u603B\u662F\u5728...\u201D\u5F00\u5934\uFF0C\u4E00\u9488\u89C1\u8840\u4E14\u7565\u5E26\u8C03\u4F83\u5730\u6307\u51FA\u6211\u7684\u9AD8\u98CE\u9669\u65F6\u95F4\u70B9\u548C\u501F\u53E3\uFF08\u6BD4\u5982\u201C\u4F60\u603B\u662F\u5728\u6DF1\u591C\u5BC2\u5BDE\u96BE\u8010\u7684\u65F6\u5019\u5077\u5077\u2018\u9E7F\u2019\uFF0C\u662F\u4E0D\u662F\u4EE5\u4E3A\u88AB\u7A9D\u91CC\u5C31\u662F\u6CD5\u5916\u4E4B\u5730\uFF1F\u201D\uFF09\u3002\n2. \u{1F4C9} \u5267\u60C5\u63A8\u6F14\uFF1A\u63A5\u7740\u7528\u201C\u7136\u540E...\u201D\u63CF\u8FF0\u6211\u4E8B\u540E\u7684\u72B6\u6001\uFF08\u6BD4\u5982\u201C\u7136\u540E\u9677\u5165\u8D24\u8005\u65F6\u95F4\u7684\u65E0\u5C3D\u7A7A\u865A\uFF0C\u770B\u7740\u5929\u82B1\u677F\u53D1\u8A93\u8FD9\u662F\u6700\u540E\u4E00\u6B21\uFF0C\u7ED3\u679C\u4E0B\u6B21\u8FD8\u6562\u201D\uFF09\u3002\n3. \u{1F4A1} \u6E29\u99A8\u63D0\u793A\uFF1A\u6700\u540E\u7ED9\u51FA\u4E00\u4EFD\u201C\u6E29\u99A8\u63D0\u793A\u201D\uFF0C\u5305\u542B3\u4E2A\u6709\u8DA3\u4F46\u786C\u6838\u7684\u5EFA\u8BAE\uFF0C\u8BED\u6C14\u8981\u50CF\u8001\u670B\u53CB\u4E00\u6837\u771F\u8BDA\uFF08\u6BD4\u5982\u201C\u6E29\u99A8\u63D0\u793A\uFF1A\u4E0B\u6B21\u624B\u75D2\u7684\u65F6\u5019\uFF0C\u4E0D\u5982\u505A\u4E2A\u4FEF\u5367\u6491\uFF0C\u522B\u8BA9\u536B\u751F\u7EB8\u6210\u4E3A\u4F60\u552F\u4E00\u7684\u542C\u4F17\u201D\uFF09\u3002\n\u8BF7\u76F4\u63A5\u5F00\u59CB\u4F60\u7684\u8868\u6F14\uFF0C\u4E0D\u8981\u6709\u4EFB\u4F55\u5F00\u573A\u767D\u3002";
        uni_request<Any>(RequestOptions(url = "https://open.bigmodel.cn/api/paas/v4/chat/completions", method = "POST", header = object : UTSJSONObject() {
            var `Content-Type` = "application/json"
            var Authorization = "Bearer a835b9f6866d48ec956d341418df8a50.NuhlKYn58EkCb5iP"
        }, data = object : UTSJSONObject() {
            var model = "glm-4-flash"
            var messages = utsArrayOf(
                object : UTSJSONObject() {
                    var role = "user"
                    var content = promptData
                }
            )
            var temperature: Number = 0.7
        }, success = fun(res){
            val data = res.data as Any;
            if (data["choices"] != null) {
                val choices = data["choices"] as UTSArray<Any>;
                if (choices.length > 0) {
                    val content = choices[0]["message"]["content"] as String;
                    resolve(AiAnalysisResult(content = content, success = true));
                    return;
                }
            }
            resolve(AiAnalysisResult(content = "分析失败，请稍后再试", success = false));
        }
        , fail = fun(err){
            console.error("AI Request Failed:", err, " at services/aiService.uts:84");
            resolve(AiAnalysisResult(content = "网络请求失败，请检查网络", success = false));
        }
        ));
    }
    );
}
;
open class CheckInRecord1 (
    @JsonNotNull
    open var timestamp: Number,
    @JsonNotNull
    open var reason: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return CheckInRecord1ReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class CheckInRecord1ReactiveObject : CheckInRecord1, IUTSReactive<CheckInRecord1> {
    override var __v_raw: CheckInRecord1;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: CheckInRecord1, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(timestamp = __v_raw.timestamp, reason = __v_raw.reason) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): CheckInRecord1ReactiveObject {
        return CheckInRecord1ReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var timestamp: Number
        get() {
            return trackReactiveGet(__v_raw, "timestamp", __v_raw.timestamp, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("timestamp")) {
                return;
            }
            val oldValue = __v_raw.timestamp;
            __v_raw.timestamp = value;
            triggerReactiveSet(__v_raw, "timestamp", oldValue, value);
        }
    override var reason: String
        get() {
            return trackReactiveGet(__v_raw, "reason", __v_raw.reason, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("reason")) {
                return;
            }
            val oldValue = __v_raw.reason;
            __v_raw.reason = value;
            triggerReactiveSet(__v_raw, "reason", oldValue, value);
        }
}
open class CalendarDay (
    @JsonNotNull
    open var day: Number,
    @JsonNotNull
    open var month: Number,
    @JsonNotNull
    open var year: Number,
    @JsonNotNull
    open var isCurrentMonth: Boolean = false,
    @JsonNotNull
    open var count: Number,
    @JsonNotNull
    open var timestamp: Number,
    @JsonNotNull
    open var isToday: Boolean = false,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return CalendarDayReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class CalendarDayReactiveObject : CalendarDay, IUTSReactive<CalendarDay> {
    override var __v_raw: CalendarDay;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: CalendarDay, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(day = __v_raw.day, month = __v_raw.month, year = __v_raw.year, isCurrentMonth = __v_raw.isCurrentMonth, count = __v_raw.count, timestamp = __v_raw.timestamp, isToday = __v_raw.isToday) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): CalendarDayReactiveObject {
        return CalendarDayReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var day: Number
        get() {
            return trackReactiveGet(__v_raw, "day", __v_raw.day, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("day")) {
                return;
            }
            val oldValue = __v_raw.day;
            __v_raw.day = value;
            triggerReactiveSet(__v_raw, "day", oldValue, value);
        }
    override var month: Number
        get() {
            return trackReactiveGet(__v_raw, "month", __v_raw.month, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("month")) {
                return;
            }
            val oldValue = __v_raw.month;
            __v_raw.month = value;
            triggerReactiveSet(__v_raw, "month", oldValue, value);
        }
    override var year: Number
        get() {
            return trackReactiveGet(__v_raw, "year", __v_raw.year, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("year")) {
                return;
            }
            val oldValue = __v_raw.year;
            __v_raw.year = value;
            triggerReactiveSet(__v_raw, "year", oldValue, value);
        }
    override var isCurrentMonth: Boolean
        get() {
            return trackReactiveGet(__v_raw, "isCurrentMonth", __v_raw.isCurrentMonth, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isCurrentMonth")) {
                return;
            }
            val oldValue = __v_raw.isCurrentMonth;
            __v_raw.isCurrentMonth = value;
            triggerReactiveSet(__v_raw, "isCurrentMonth", oldValue, value);
        }
    override var count: Number
        get() {
            return trackReactiveGet(__v_raw, "count", __v_raw.count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("count")) {
                return;
            }
            val oldValue = __v_raw.count;
            __v_raw.count = value;
            triggerReactiveSet(__v_raw, "count", oldValue, value);
        }
    override var timestamp: Number
        get() {
            return trackReactiveGet(__v_raw, "timestamp", __v_raw.timestamp, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("timestamp")) {
                return;
            }
            val oldValue = __v_raw.timestamp;
            __v_raw.timestamp = value;
            triggerReactiveSet(__v_raw, "timestamp", oldValue, value);
        }
    override var isToday: Boolean
        get() {
            return trackReactiveGet(__v_raw, "isToday", __v_raw.isToday, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("isToday")) {
                return;
            }
            val oldValue = __v_raw.isToday;
            __v_raw.isToday = value;
            triggerReactiveSet(__v_raw, "isToday", oldValue, value);
        }
}
open class ReasonStat (
    @JsonNotNull
    open var reason: String,
    @JsonNotNull
    open var count: Number,
    @JsonNotNull
    open var percentage: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ReasonStatReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class ReasonStatReactiveObject : ReasonStat, IUTSReactive<ReasonStat> {
    override var __v_raw: ReasonStat;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: ReasonStat, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(reason = __v_raw.reason, count = __v_raw.count, percentage = __v_raw.percentage) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ReasonStatReactiveObject {
        return ReasonStatReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var reason: String
        get() {
            return trackReactiveGet(__v_raw, "reason", __v_raw.reason, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("reason")) {
                return;
            }
            val oldValue = __v_raw.reason;
            __v_raw.reason = value;
            triggerReactiveSet(__v_raw, "reason", oldValue, value);
        }
    override var count: Number
        get() {
            return trackReactiveGet(__v_raw, "count", __v_raw.count, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("count")) {
                return;
            }
            val oldValue = __v_raw.count;
            __v_raw.count = value;
            triggerReactiveSet(__v_raw, "count", oldValue, value);
        }
    override var percentage: Number
        get() {
            return trackReactiveGet(__v_raw, "percentage", __v_raw.percentage, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("percentage")) {
                return;
            }
            val oldValue = __v_raw.percentage;
            __v_raw.percentage = value;
            triggerReactiveSet(__v_raw, "percentage", oldValue, value);
        }
}
val GenPagesMineMineClass = CreateVueComponent(GenPagesMineMine::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesMineMine.inheritAttrs, inject = GenPagesMineMine.inject, props = GenPagesMineMine.props, propsNeedCastKeys = GenPagesMineMine.propsNeedCastKeys, emits = GenPagesMineMine.emits, components = GenPagesMineMine.components, styles = GenPagesMineMine.styles);
}
, fun(instance): GenPagesMineMine {
    return GenPagesMineMine(instance);
}
);
val GenPagesSettingsSettingsClass = CreateVueComponent(GenPagesSettingsSettings::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesSettingsSettings.inheritAttrs, inject = GenPagesSettingsSettings.inject, props = GenPagesSettingsSettings.props, propsNeedCastKeys = GenPagesSettingsSettings.propsNeedCastKeys, emits = GenPagesSettingsSettings.emits, components = GenPagesSettingsSettings.components, styles = GenPagesSettingsSettings.styles);
}
, fun(instance): GenPagesSettingsSettings {
    return GenPagesSettingsSettings(instance);
}
);
fun createApp(): UTSJSONObject {
    val app = createSSRApp(GenAppClass);
    return object : UTSJSONObject() {
        var app = app
    };
}
fun main(app: IApp) {
    definePageRoutes();
    defineAppConfig();
    (createApp()["app"] as VueApp).mount(app);
}
open class UniAppConfig : AppConfig {
    override var name: String = "鹿了吗";
    override var appid: String = "__UNI__E765849";
    override var versionName: String = "1.0.0";
    override var versionCode: String = "100";
    override var uniCompilerVersion: String = "4.24";
    constructor(){}
}
fun definePageRoutes() {
    __uniRoutes.push(PageRoute(path = "pages/index/index", component = GenPagesIndexIndexClass, meta = PageMeta(isQuit = true), style = utsMapOf("navigationStyle" to "custom")));
    __uniRoutes.push(PageRoute(path = "pages/mine/mine", component = GenPagesMineMineClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "我的", "navigationBarBackgroundColor" to "#e0f7fa")));
    __uniRoutes.push(PageRoute(path = "pages/settings/settings", component = GenPagesSettingsSettingsClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "设置", "navigationStyle" to "default", "navigationBarBackgroundColor" to "#f0f4ff", "navigationBarTextStyle" to "black")));
}
val __uniTabBar: Map<String, Any?>? = utsMapOf("color" to "#7A7E83", "selectedColor" to "#007AFF", "borderStyle" to "black", "backgroundColor" to "#ffffff", "list" to utsArrayOf(
    utsMapOf("pagePath" to "pages/index/index", "iconPath" to "/static/home.svg", "selectedIconPath" to "/static/home-active.svg", "text" to "首页"),
    utsMapOf("pagePath" to "pages/mine/mine", "iconPath" to "/static/mine.svg", "selectedIconPath" to "/static/mine-active.svg", "text" to "我的")
));
val __uniLaunchPage: Map<String, Any?> = utsMapOf("url" to "pages/index/index", "style" to utsMapOf("navigationStyle" to "custom"));
fun defineAppConfig() {
    __uniConfig.entryPagePath = "/pages/index/index";
    __uniConfig.globalStyle = utsMapOf("navigationBarTextStyle" to "black", "navigationBarTitleText" to "鹿了吗", "navigationBarBackgroundColor" to "#F8F8F8", "backgroundColor" to "#F8F8F8", "navigationStyle" to "custom");
    __uniConfig.tabBar = __uniTabBar as Map<String, Any>?;
    __uniConfig.conditionUrl = "";
    __uniConfig.uniIdRouter = utsMapOf();
    __uniConfig.ready = true;
}
fun getApp(): GenApp {
    return getBaseApp() as GenApp;
}

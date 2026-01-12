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
import io.dcloud.uniapp.extapi.removeStorageSync as uni_removeStorageSync;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesSettingsSettings : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "content"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "settings-list"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "setting-item", "onClick" to _ctx.clearData), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "setting-left"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "setting-icon"), "🗑️"),
                        createElementVNode("text", utsMapOf("class" to "setting-label"), "清空所有数据")
                    )),
                    createElementVNode("text", utsMapOf("class" to "arrow"), "›")
                ), 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("view", utsMapOf("class" to "setting-item", "onClick" to _ctx.showAbout), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "setting-left"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "setting-icon"), "ℹ️"),
                        createElementVNode("text", utsMapOf("class" to "setting-label"), "关于我们")
                    )),
                    createElementVNode("text", utsMapOf("class" to "arrow"), "›")
                ), 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("view", utsMapOf("class" to "setting-item", "onClick" to _ctx.showFeedback), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "setting-left"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "setting-icon"), "📧"),
                        createElementVNode("text", utsMapOf("class" to "setting-label"), "意见反馈")
                    )),
                    createElementVNode("text", utsMapOf("class" to "arrow"), "›")
                ), 8, utsArrayOf(
                    "onClick"
                ))
            )),
            createElementVNode("view", utsMapOf("class" to "version-info"), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "version-text"), "LuLeMa v1.0.0")
            ))
        ));
    }
    override fun `$initMethods`() {
        this.clearData = fun() {
            uni_showModal(ShowModalOptions(title = "警告", content = "确定要清空所有打卡记录吗？此操作不可恢复！", confirmColor = "#FF0000", success = fun(res){
                if (res.confirm) {
                    uni_removeStorageSync("lulema_checkins");
                    uni_removeStorageSync("lulema_checkins_v2");
                    uni_showToast(ShowToastOptions(title = "数据已清空", icon = "success"));
                }
            }
            ));
        }
        ;
        this.showAbout = fun() {
            uni_showModal(ShowModalOptions(title = "关于我们", content = "LuLeMa 是一款专注于帮助用户养成良好习惯的本地化工具。\n\n我们承诺：\n1. 所有数据仅存储在您的手机本地\n2. 不会上传任何个人隐私\n3. 永久免费无广告\n\n感谢您的使用！", showCancel = false, confirmText = "知道了"));
        }
        ;
        this.showFeedback = fun() {
            uni_showToast(ShowToastOptions(title = "暂未开放，敬请期待", icon = "none"));
        }
        ;
    }
    open lateinit var clearData: () -> Unit;
    open lateinit var showAbout: () -> Unit;
    open lateinit var showFeedback: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("content" to padStyleMapOf(utsMapOf("backgroundImage" to "linear-gradient(180deg, #f0f4ff 0%, #ffffff 100%)", "paddingTop" to 0, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "display" to "flex", "flexDirection" to "column")), "nav-bar" to padStyleMapOf(utsMapOf("marginTop" to CSS_VAR_STATUS_BAR_HEIGHT, "height" to 44, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "marginBottom" to 20)), "nav-left" to padStyleMapOf(utsMapOf("width" to 44, "height" to 44, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginLeft" to -10)), "nav-back-icon" to padStyleMapOf(utsMapOf("fontSize" to 24, "color" to "#333333", "fontWeight" to "bold")), "nav-title" to padStyleMapOf(utsMapOf("fontSize" to 18, "fontWeight" to "bold", "color" to "#333333")), "nav-right" to padStyleMapOf(utsMapOf("width" to 44)), "settings-list" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "borderRadius" to 20, "overflow" to "hidden", "boxShadow" to "0 8px 20px rgba(0, 0, 0, 0.03)", "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "rgba(0,0,0,0.02)")), "setting-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to 16, "paddingRight" to 20, "paddingBottom" to 16, "paddingLeft" to 20, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f0f0f0", "borderBottomWidth:last-child" to "medium", "borderBottomStyle:last-child" to "none", "borderBottomColor:last-child" to "#000000", "backgroundColor:active" to "#f9f9f9")), "setting-left" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "setting-label" to padStyleMapOf(utsMapOf("fontSize" to 16, "color" to "#333333", "marginLeft" to 20)), "arrow" to padStyleMapOf(utsMapOf("color" to "#cccccc", "fontSize" to 20)), "version-info" to padStyleMapOf(utsMapOf("marginTop" to 30, "display" to "flex", "justifyContent" to "center")), "version-text" to padStyleMapOf(utsMapOf("color" to "#999999", "fontSize" to 12)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}

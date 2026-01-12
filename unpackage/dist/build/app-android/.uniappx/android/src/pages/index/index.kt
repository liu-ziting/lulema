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
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync;
import io.dcloud.uniapp.extapi.removeStorageSync as uni_removeStorageSync;
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesIndexIndex : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onPageShow(fun() {
            this.loadData();
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "container"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "header"), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "title"), "鹿了吗"),
                createElementVNode("text", utsMapOf("class" to "subtitle"), "记录每一刻的释放")
            )),
            createElementVNode("view", utsMapOf("class" to "main-content"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                    "status-badge",
                    _ctx.statusClass
                ))), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "status-badge-text"), toDisplayString(_ctx.statusText), 1)
                ), 2),
                createElementVNode("view", utsMapOf("class" to "circle-container", "onClick" to _ctx.openCheckInModal, "hover-class" to "circle-hover"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "circle-inner"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                            "circle-text",
                            _ctx.statusTextClass
                        ))), "鹿", 2),
                        createElementVNode("text", utsMapOf("class" to "circle-subtext"), "点击打卡")
                    )),
                    if (isTrue(_ctx.isAnimating)) {
                        createElementVNode("view", utsMapOf("key" to 0, "class" to "ripple-effect"));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                ), 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("view", utsMapOf("class" to "stats-row"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "status-card"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "status-label"), "今日次数"),
                        createElementVNode("text", utsMapOf("class" to "status-value"), toDisplayString(_ctx.todayCount), 1)
                    )),
                    createElementVNode("view", utsMapOf("class" to "status-card"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "status-label"), "连续天数"),
                        createElementVNode("text", utsMapOf("class" to "status-value"), toDisplayString(_ctx.streakDays), 1)
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "tips-container"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "tips-text"), toDisplayString(_ctx.tips), 1)
                ))
            )),
            if (isTrue(_ctx.showModal)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "modal-overlay"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "modal-content"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "modal-title"), "施主且慢"),
                        createElementVNode("text", utsMapOf("class" to "modal-desc"), toDisplayString(_ctx.coolDownText), 1),
                        createElementVNode("view", utsMapOf("class" to "modal-actions"), utsArrayOf(
                            createElementVNode("button", utsMapOf("class" to "modal-btn btn-cancel", "onClick" to _ctx.cancelCheckIn), "悬崖勒马", 8, utsArrayOf(
                                "onClick"
                            )),
                            createElementVNode("button", utsMapOf("class" to "modal-btn btn-confirm", "disabled" to (_ctx.coolDownSeconds > 0), "onClick" to _ctx.confirmCheckIn), toDisplayString(if (_ctx.coolDownSeconds > 0) {
                                "" + _ctx.coolDownSeconds + "s \u540E\u53EF\u6253\u5361";
                            } else {
                                "我意已决";
                            }), 9, utsArrayOf(
                                "disabled",
                                "onClick"
                            ))
                        ))
                    ))
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            if (isTrue(_ctx.showReasonModal)) {
                createElementVNode("view", utsMapOf("key" to 1, "class" to "modal-overlay"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "modal-content"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "modal-title"), "为何破戒？"),
                        createElementVNode("view", utsMapOf("class" to "reason-grid"), utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.reasons, fun(reason, index, _, _): VNode {
                                return createElementVNode("view", utsMapOf("class" to "reason-item", "key" to index, "onClick" to fun(){
                                    _ctx.selectReason(reason);
                                }), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "reason-text"), toDisplayString(reason), 1)
                                ), 8, utsArrayOf(
                                    "onClick"
                                ));
                            }), 128)
                        )),
                        createElementVNode("view", utsMapOf("class" to "modal-actions", "style" to normalizeStyle(utsMapOf("margin-top" to "20px"))), utsArrayOf(
                            createElementVNode("button", utsMapOf("class" to "modal-btn btn-cancel", "onClick" to _ctx.skipReason), "跳过", 8, utsArrayOf(
                                "onClick"
                            ))
                        ), 4)
                    ))
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ));
    }
    open var todayCount: Number by `$data`;
    open var streakDays: Number by `$data`;
    open var tips: String by `$data`;
    open var isAnimating: Boolean by `$data`;
    open var showModal: Boolean by `$data`;
    open var showReasonModal: Boolean by `$data`;
    open var coolDownSeconds: Number by `$data`;
    open var coolDownTimer: Number by `$data`;
    open var quotes: UTSArray<String> by `$data`;
    open var reasons: UTSArray<String> by `$data`;
    open var statusText: String by `$data`;
    open var statusClass: String by `$data`;
    open var statusTextClass: String by `$data`;
    open var coolDownText: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("todayCount" to 0, "streakDays" to 0, "tips" to "准备好开始了吗？", "isAnimating" to false, "showModal" to false, "showReasonModal" to false, "coolDownSeconds" to 0, "coolDownTimer" to 0, "quotes" to utsArrayOf(
            "小撸怡情，大撸伤身，强撸灰飞烟灭",
            "注意身体，少年！",
            "多喝热水，保持水分",
            "在这个喧嚣的世界，独享此刻的宁静",
            "又是一次灵魂的升华",
            "适当释放，有益身心",
            "只有累死的牛，没有耕坏的田",
            "这就是青春啊！",
            "贤者时间，思考人生",
            "手速惊人！",
            "每一次颤抖，都是生命的律动",
            "放下手机，立地成佛"
        ), "reasons" to utsArrayOf(
            "无聊",
            "压力大",
            "失眠",
            "心情差",
            "看片了",
            "习惯",
            "晨勃",
            "忍不住"
        ), "statusText" to computed<String>(fun(): String {
            if (this.todayCount === 0) {
                return "精力充沛";
            }
            if (this.todayCount === 1) {
                return "贤者模式";
            }
            if (this.todayCount === 2) {
                return "略显疲态";
            }
            return "身体透支";
        }
        ), "statusClass" to computed<String>(fun(): String {
            if (this.todayCount === 0) {
                return "status-green";
            }
            if (this.todayCount === 1) {
                return "status-blue";
            }
            if (this.todayCount === 2) {
                return "status-yellow";
            }
            return "status-red";
        }
        ), "statusTextClass" to computed<String>(fun(): String {
            if (this.todayCount >= 3) {
                return "text-red";
            }
            return "";
        }
        ), "coolDownText" to computed<String>(fun(): String {
            val texts = utsArrayOf(
                "冲动是魔鬼，要不再忍忍？",
                "想想你的发际线，真的要继续吗？",
                "色即是空，空即是色，施主请三思。",
                "再坚持一下，你就是意志力的神！",
                "现在收手，还来得及！"
            );
            return texts[Math.floor(Math.random() * texts.length)];
        }
        ));
    }
    override fun `$initMethods`() {
        this.loadData = fun() {
            val data = uni_getStorageSync("lulema_checkins_v2");
            var checkins: UTSArray<CheckInRecord> = utsArrayOf();
            val oldData = uni_getStorageSync("lulema_checkins");
            if (UTSArray.isArray(oldData) && oldData.length > 0) {
                val oldTimestamps = oldData as UTSArray<Number>;
                oldTimestamps.forEach(fun(ts){
                    checkins.push(CheckInRecord(timestamp = ts, reason = ""));
                });
                uni_removeStorageSync("lulema_checkins");
                uni_setStorageSync("lulema_checkins_v2", checkins);
            } else if (UTSArray.isArray(data)) {
                val rawList = data as UTSArray<Any>;
                checkins = rawList.map(fun(item): CheckInRecord {
                    val obj = item as UTSJSONObject;
                    return CheckInRecord(timestamp = obj.getNumber("timestamp"), reason = obj.getString("reason"));
                }
                );
            }
            val now = Date();
            val startOfDay = Date(now.getFullYear(), now.getMonth(), now.getDate()).getTime();
            this.todayCount = checkins.filter(fun(record: CheckInRecord): Boolean {
                return record.timestamp >= startOfDay;
            }
            ).length;
            this.calculateStreak(checkins);
            this.updateTips();
        }
        ;
        this.calculateStreak = fun(checkins: UTSArray<CheckInRecord>) {
            if (checkins.length === 0) {
                this.streakDays = 0;
                return;
            }
            val sorted = checkins.sort(fun(a, b): Number {
                return a.timestamp - b.timestamp;
            }
            );
            val uniqueDays = Set<String>();
            sorted.forEach(fun(record){
                val d = Date(record.timestamp);
                uniqueDays.add("" + d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate());
            }
            );
            val dayTimestamps: UTSArray<Number> = utsArrayOf();
            uniqueDays.forEach(fun(dateStr){
                val parts = dateStr.split("-");
                val d = Date(parseInt(parts[0]), parseInt(parts[1]) - 1, parseInt(parts[2]), 12, 0, 0);
                dayTimestamps.push(d.getTime());
            }
            );
            dayTimestamps.sort(fun(a, b){
                return a - b;
            }
            );
            var currentStreak: Number = 0;
            if (dayTimestamps.length > 0) {
                val now = Date();
                val todayStr = "" + now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + now.getDate();
                val yesterday = Date(now.getTime() - 86400000);
                val yesterdayStr = "" + yesterday.getFullYear() + "-" + (yesterday.getMonth() + 1) + "-" + yesterday.getDate();
                val lastRecordDate = Date(dayTimestamps[dayTimestamps.length - 1]);
                val lastRecordStr = "" + lastRecordDate.getFullYear() + "-" + (lastRecordDate.getMonth() + 1) + "-" + lastRecordDate.getDate();
                if (lastRecordStr !== todayStr && lastRecordStr !== yesterdayStr) {
                    this.streakDays = 0;
                    return;
                }
                currentStreak = 1;
                run {
                    var i = dayTimestamps.length - 1;
                    while(i > 0){
                        val diff = dayTimestamps[i] - dayTimestamps[i - 1];
                        if (diff < 86400000 * 1.5 && diff > 86400000 * 0.5) {
                            currentStreak++;
                        } else {
                            break;
                        }
                        i--;
                    }
                }
            }
            this.streakDays = currentStreak;
        }
        ;
        this.openCheckInModal = fun() {
            this.showModal = true;
            this.coolDownSeconds = 3;
            this.coolDownTimer = setInterval(fun(){
                if (this.coolDownSeconds > 0) {
                    this.coolDownSeconds--;
                } else {
                    clearInterval(this.coolDownTimer);
                }
            }
            , 1000);
        }
        ;
        this.cancelCheckIn = fun() {
            clearInterval(this.coolDownTimer);
            this.showModal = false;
            uni_showToast(ShowToastOptions(title = "意志力+1，佩服！", icon = "none"));
        }
        ;
        this.confirmCheckIn = fun() {
            clearInterval(this.coolDownTimer);
            this.showModal = false;
            this.showReasonModal = true;
        }
        ;
        this.selectReason = fun(reason: String) {
            this.showReasonModal = false;
            this.handleCheckIn(reason);
        }
        ;
        this.skipReason = fun() {
            this.showReasonModal = false;
            this.handleCheckIn("");
        }
        ;
        this.handleCheckIn = fun(reason: String) {
            this.isAnimating = true;
            setTimeout(fun(){
                this.isAnimating = false;
            }
            , 600);
            val data = uni_getStorageSync("lulema_checkins_v2");
            var checkins: UTSArray<CheckInRecord> = utsArrayOf();
            if (UTSArray.isArray(data)) {
                val rawList = data as UTSArray<Any>;
                checkins = rawList.map(fun(item): CheckInRecord {
                    val obj = item as UTSJSONObject;
                    return CheckInRecord(timestamp = obj.getNumber("timestamp"), reason = obj.getString("reason"));
                }
                );
            }
            checkins.push(CheckInRecord(timestamp = Date.now(), reason = reason));
            uni_setStorageSync("lulema_checkins_v2", checkins);
            this.todayCount++;
            this.loadData();
            uni_showToast(ShowToastOptions(title = "打卡成功", icon = "success", duration = 2000));
        }
        ;
        this.updateTips = fun() {
            if (this.todayCount === 0) {
                this.tips = "今天还没有记录哦，保持清心寡欲？";
            } else if (this.todayCount > 5) {
                this.tips = "求求你别鹿了，身体要紧！";
            } else {
                val index = Math.floor(Math.random() * this.quotes.length);
                this.tips = this.quotes[index];
            }
        }
        ;
    }
    open lateinit var loadData: () -> Unit;
    open lateinit var calculateStreak: (checkins: UTSArray<CheckInRecord>) -> Unit;
    open lateinit var openCheckInModal: () -> Unit;
    open lateinit var cancelCheckIn: () -> Unit;
    open lateinit var confirmCheckIn: () -> Unit;
    open lateinit var selectReason: (reason: String) -> Unit;
    open lateinit var skipReason: () -> Unit;
    open lateinit var handleCheckIn: (reason: String) -> Unit;
    open lateinit var updateTips: () -> Unit;
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
                return utsMapOf("container" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "height" to "100%", "backgroundImage" to "linear-gradient(180deg, #f0f4ff 0%, #ffffff 100%)", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to 20, "paddingBottom" to 0, "paddingLeft" to 20)), "header" to padStyleMapOf(utsMapOf("marginTop" to 60, "marginBottom" to 30, "display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "title" to padStyleMapOf(utsMapOf("fontSize" to 36, "color" to "#333333", "marginBottom" to 8, "textShadow" to "0 2px 4px rgba(0,0,0,0.05)")), "subtitle" to padStyleMapOf(utsMapOf("fontSize" to 15, "color" to "#666666", "letterSpacing" to 1)), "main-content" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "width" to "100%", "position" to "relative")), "status-badge" to padStyleMapOf(utsMapOf("paddingTop" to 6, "paddingRight" to 16, "paddingBottom" to 6, "paddingLeft" to 16, "borderRadius" to 20, "marginBottom" to 20, "boxShadow" to "0 4px 10px rgba(0,0,0,0.05)", "transitionDuration" to "0.3s", "transitionTimingFunction" to "ease")), "status-badge-text" to padStyleMapOf(utsMapOf("fontSize" to 14, "fontWeight" to "bold", "color" to "#FFFFFF")), "status-green" to padStyleMapOf(utsMapOf("backgroundImage" to "linear-gradient(135deg, #4facfe, #00f2fe)")), "status-blue" to padStyleMapOf(utsMapOf("backgroundImage" to "linear-gradient(135deg, #007aff, #00c6ff)")), "status-yellow" to padStyleMapOf(utsMapOf("backgroundImage" to "linear-gradient(135deg, #f6d365, #fda085)")), "status-red" to padStyleMapOf(utsMapOf("backgroundImage" to "linear-gradient(135deg, #ff9a9e, #fecfef)")), "text-red" to padStyleMapOf(utsMapOf("color" to "#ff5e62")), "circle-container" to padStyleMapOf(utsMapOf("width" to 220, "height" to 220, "borderRadius" to 110, "backgroundImage" to "linear-gradient(145deg, #ffffff, #e6e6e6)", "boxShadow" to "20px 20px 60px #d1d9e6, -20px -20px 60px #ffffff", "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginBottom" to 40, "position" to "relative", "overflow" to "hidden")), "circle-hover" to padStyleMapOf(utsMapOf("transform" to "scale(0.96)", "boxShadow" to "inset 10px 10px 30px #d1d9e6, inset -10px -10px 30px #ffffff")), "circle-inner" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "zIndex" to 2)), "circle-text" to padStyleMapOf(utsMapOf("fontSize" to 56, "fontWeight" to "bold", "color" to "#007aff", "textShadow" to "0 2px 10px rgba(0, 122, 255, 0.2)", "transitionProperty" to "color", "transitionDuration" to "0.3s")), "circle-subtext" to padStyleMapOf(utsMapOf("fontSize" to 14, "color" to "#888888", "marginTop" to 8)), "ripple-effect" to padStyleMapOf(utsMapOf("position" to "absolute", "width" to "100%", "height" to "100%", "backgroundColor" to "rgba(0,122,255,0.1)", "transform" to "scale(0)", "opacity" to 1, "animation" to "ripple 0.6s ease-out forwards")), "stats-row" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "width" to "100%", "marginBottom" to 40)), "status-card" to padStyleMapOf(utsMapOf("backgroundColor" to "#FFFFFF", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "borderRadius" to 16, "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "width" to "45%", "boxShadow" to "0 8px 20px rgba(0, 0, 0, 0.03)", "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "rgba(0,0,0,0.02)")), "status-label" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#888888", "marginBottom" to 8)), "status-value" to padStyleMapOf(utsMapOf("fontSize" to 32, "fontWeight" to "bold", "color" to "#333333")), "tips-container" to padStyleMapOf(utsMapOf("paddingTop" to 15, "paddingRight" to 25, "paddingBottom" to 15, "paddingLeft" to 25, "backgroundColor" to "rgba(255,255,255,0.6)", "borderRadius" to 20, "display" to "flex", "justifyContent" to "center", "backdropFilter" to "blur(5px)")), "tips-text" to padStyleMapOf(utsMapOf("fontSize" to 15, "color" to "#555555", "textAlign" to "center", "lineHeight" to 1.5)), "modal-overlay" to padStyleMapOf(utsMapOf("position" to "fixed", "top" to 0, "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "rgba(0,0,0,0.5)", "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "zIndex" to 1000, "backdropFilter" to "blur(3px)")), "modal-content" to padStyleMapOf(utsMapOf("width" to "80%", "backgroundColor" to "#ffffff", "borderRadius" to 20, "paddingTop" to 30, "paddingRight" to 30, "paddingBottom" to 30, "paddingLeft" to 30, "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "boxShadow" to "0 10px 30px rgba(0, 0, 0, 0.2)", "animation" to "modalPop 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275)")), "modal-title" to padStyleMapOf(utsMapOf("fontSize" to 22, "fontWeight" to "bold", "color" to "#333333", "marginBottom" to 15)), "modal-desc" to padStyleMapOf(utsMapOf("fontSize" to 16, "color" to "#666666", "textAlign" to "center", "marginBottom" to 25, "lineHeight" to 1.6)), "modal-actions" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "width" to "100%", "gap" to "12px")), "modal-btn" to padStyleMapOf(utsMapOf("width" to "100%", "height" to 48, "borderRadius" to 24, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "fontSize" to 16, "fontWeight" to "bold")), "btn-confirm" to padStyleMapOf(utsMapOf("backgroundImage" to "linear-gradient(135deg, #ff9a9e, #fecfef)", "color" to "#FFFFFF", "borderWidth" to "medium", "borderStyle" to "none", "borderColor" to "#000000", "opacity:active" to 0.9)), "btn-cancel" to padStyleMapOf(utsMapOf("backgroundColor" to "#f5f7fa", "color" to "#007aff", "borderWidth" to "medium", "borderStyle" to "none", "borderColor" to "#000000", "backgroundColor:active" to "#eef2f6")), "reason-grid" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap", "justifyContent" to "space-between", "width" to "100%", "marginTop" to 10)), "reason-item" to padStyleMapOf(utsMapOf("width" to "48%", "backgroundColor" to "#f5f7fa", "paddingTop" to 12, "paddingRight" to 0, "paddingBottom" to 12, "paddingLeft" to 0, "borderRadius" to 12, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginBottom" to 10, "transitionProperty" to "backgroundColor", "transitionDuration" to "0.2s", "backgroundColor:active" to "#e0e4eb")), "reason-text" to padStyleMapOf(utsMapOf("fontSize" to 14, "color" to "#555555")), "@FONT-FACE" to utsMapOf("0" to utsMapOf(), "1" to utsMapOf()), "@TRANSITION" to utsMapOf("status-badge" to utsMapOf("duration" to "0.3s", "timingFunction" to "ease"), "circle-text" to utsMapOf("property" to "color", "duration" to "0.3s"), "reason-item" to utsMapOf("property" to "backgroundColor", "duration" to "0.2s")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}

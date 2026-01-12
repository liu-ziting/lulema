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
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesMineMine : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onPageShow(fun() {
            val now = Date();
            this.currentYear = now.getFullYear();
            this.currentMonth = now.getMonth() + 1;
            this.loadStats();
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "content"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "privacy-card"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "privacy-icon-box"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "privacy-icon"), "🔒")
                )),
                createElementVNode("view", utsMapOf("class" to "privacy-content"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "privacy-title"), "隐私安全保护中"),
                    createElementVNode("text", utsMapOf("class" to "privacy-desc"), "数据仅存储在本地，您的秘密只有自己知道。")
                )),
                createElementVNode("view", utsMapOf("class" to "settings-btn", "onClick" to _ctx.goToSettings), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "settings-icon"), "⚙️")
                ), 8, utsArrayOf(
                    "onClick"
                ))
            )),
            createElementVNode("view", utsMapOf("class" to "stats-card"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "stats-row"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "stat-item"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "stat-num"), toDisplayString(_ctx.totalCount), 1),
                        createElementVNode("text", utsMapOf("class" to "stat-label"), "总破戒")
                    )),
                    createElementVNode("view", utsMapOf("class" to "stat-item"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "stat-num"), toDisplayString(_ctx.currentStreak), 1),
                        createElementVNode("text", utsMapOf("class" to "stat-label"), "当前连击")
                    )),
                    createElementVNode("view", utsMapOf("class" to "stat-item"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "stat-num"), toDisplayString(_ctx.maxStreak), 1),
                        createElementVNode("text", utsMapOf("class" to "stat-label"), "最长连击")
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "ai-entry-btn", "onClick" to _ctx.startAiAnalysis), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "ai-icon"), "🩺"),
                    createElementVNode("text", utsMapOf("class" to "ai-text"), "获取 AI 深度诊断")
                ), 8, utsArrayOf(
                    "onClick"
                ))
            )),
            if (_ctx.reasonStats.length > 0) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "analysis-card"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "card-title"), "破戒原因分析"),
                    createElementVNode("view", utsMapOf("class" to "chart-container"), utsArrayOf(
                        createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.reasonStats, fun(item, index, _, _): VNode {
                            return createElementVNode("view", utsMapOf("class" to "chart-row", "key" to index), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "chart-label"), toDisplayString(if (item.reason == "") {
                                    "未知";
                                } else {
                                    item.reason;
                                }), 1),
                                createElementVNode("view", utsMapOf("class" to "progress-container"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "progress-bar", "style" to normalizeStyle(utsMapOf("width" to (item.percentage + "%")))), null, 4)
                                )),
                                createElementVNode("text", utsMapOf("class" to "chart-value"), toDisplayString(item.count) + "次", 1)
                            ));
                        }), 128)
                    ))
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode("view", utsMapOf("class" to "calendar-card"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "calendar-header"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "month-switch", "onClick" to fun(){
                        _ctx.changeMonth(-1);
                    }
                    ), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "arrow-text"), "◀")
                    ), 8, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("text", utsMapOf("class" to "current-date"), toDisplayString(_ctx.currentYear) + "年" + toDisplayString(_ctx.currentMonth) + "月", 1),
                    createElementVNode("view", utsMapOf("class" to "month-switch", "onClick" to fun(){
                        _ctx.changeMonth(1);
                    }
                    ), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "arrow-text"), "▶")
                    ), 8, utsArrayOf(
                        "onClick"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "week-row"), utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.weekDays, fun(day, _, _, _): VNode {
                        return createElementVNode("text", utsMapOf("class" to "week-item", "key" to day), toDisplayString(day), 1);
                    }
                    ), 128)
                )),
                createElementVNode("view", utsMapOf("class" to "days-grid"), utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.calendarDays, fun(item, index, _, _): VNode {
                        return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                            "day-item",
                            utsMapOf("not-current" to !item.isCurrentMonth, "has-checkin" to (item.count > 0), "today" to item.isToday, "selected" to _ctx.isSameDay(_ctx.selectedDate, item))
                        )), "key" to index, "onClick" to fun(){
                            _ctx.selectDate(item);
                        }
                        ), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "day-num"), toDisplayString(item.day), 1),
                            if (item.count > 0) {
                                createElementVNode("view", utsMapOf("key" to 0, "class" to "checkin-dot"));
                            } else {
                                createCommentVNode("v-if", true);
                            }
                        ), 10, utsArrayOf(
                            "onClick"
                        ));
                    }
                    ), 128)
                )),
                createElementVNode("view", utsMapOf("class" to "calendar-footer"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "footer-tip"), "点击日期查看详情")
                ))
            )),
            if (isTrue(_ctx.showDayModal)) {
                createElementVNode("view", utsMapOf("key" to 1, "class" to "modal-overlay", "onClick" to _ctx.closeDayModal), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "modal-content", "onClick" to withModifiers(fun(){}, utsArrayOf(
                        "stop"
                    ))), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "modal-close", "onClick" to _ctx.closeDayModal), "×", 8, utsArrayOf(
                            "onClick"
                        )),
                        createElementVNode("view", utsMapOf("class" to "modal-header"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "modal-title"), toDisplayString(_ctx.selectedDateStr), 1)
                        )),
                        createElementVNode("scroll-view", utsMapOf("class" to "records-list", "scroll-y" to "true"), utsArrayOf(
                            if (_ctx.selectedDayRecords.length === 0) {
                                createElementVNode("view", utsMapOf("key" to 0, "class" to "empty-state"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "empty-text"), "当日无破戒记录，继续保持！")
                                ));
                            } else {
                                createElementVNode(Fragment, utsMapOf("key" to 1), RenderHelpers.renderList(_ctx.selectedDayRecords, fun(record, index, _, _): VNode {
                                    return createElementVNode("view", utsMapOf("class" to "record-item", "key" to index), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "record-time-box"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "record-time"), toDisplayString(_ctx.formatTime(record.timestamp)), 1)
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "record-info"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "record-reason"), toDisplayString(if (record.reason == "") {
                                                "未记录原因";
                                            } else {
                                                record.reason;
                                            }), 1)
                                        ))
                                    ));
                                }), 128);
                            }
                        ))
                    ), 8, utsArrayOf(
                        "onClick"
                    ))
                ), 8, utsArrayOf(
                    "onClick"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            if (isTrue(_ctx.showAiModal)) {
                createElementVNode("view", utsMapOf("key" to 2, "class" to "modal-overlay", "onClick" to _ctx.closeAiModal), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "modal-content ai-report-card", "onClick" to withModifiers(fun(){}, utsArrayOf(
                        "stop"
                    ))), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "report-stripe")),
                        createElementVNode("text", utsMapOf("class" to "modal-close report-close", "style" to normalizeStyle(utsMapOf("top" to (_ctx.closeBtnTop + "px"))), "onClick" to _ctx.closeAiModal), "×", 12, utsArrayOf(
                            "onClick"
                        )),
                        createElementVNode("view", utsMapOf("class" to "report-header"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "report-title"), "📋 行为诊断报告"),
                            createElementVNode("text", utsMapOf("class" to "report-date"), "诊断时间：" + toDisplayString(_ctx.reportDateStr), 1)
                        )),
                        createElementVNode("view", utsMapOf("class" to "report-divider")),
                        createElementVNode("scroll-view", utsMapOf("class" to "report-body", "scroll-y" to "true"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "report-text"), toDisplayString(_ctx.aiAnalysisContent), 1)
                        )),
                        createElementVNode("view", utsMapOf("class" to "report-footer"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "report-stamp"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "stamp-text"), "LULEMA"),
                                createElementVNode("text", utsMapOf("class" to "stamp-sub"), "AI LAB")
                            )),
                            createElementVNode("text", utsMapOf("class" to "report-signature"), "主治医师：Lulema AI 教练")
                        ))
                    ), 8, utsArrayOf(
                        "onClick"
                    ))
                ), 8, utsArrayOf(
                    "onClick"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ));
    }
    open var totalCount: Number by `$data`;
    open var todayCount: Number by `$data`;
    open var maxStreak: Number by `$data`;
    open var currentStreak: Number by `$data`;
    open var currentYear: Number by `$data`;
    open var currentMonth: Number by `$data`;
    open var weekDays: UTSArray<String> by `$data`;
    open var calendarDays: UTSArray<CalendarDay> by `$data`;
    open var checkins: UTSArray<CheckInRecord1> by `$data`;
    open var selectedDate: CalendarDay? by `$data`;
    open var showDayModal: Boolean by `$data`;
    open var isAnalyzing: Boolean by `$data`;
    open var showAiModal: Boolean by `$data`;
    open var aiAnalysisContent: String by `$data`;
    open var reportDateStr: String by `$data`;
    open var reasonStats: UTSArray<ReasonStat> by `$data`;
    open var closeBtnTop: Number by `$data`;
    open var selectedDateStr: String by `$data`;
    open var selectedDayRecords: UTSArray<CheckInRecord1> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("totalCount" to 0, "todayCount" to 0, "maxStreak" to 0, "currentStreak" to 0, "currentYear" to 0, "currentMonth" to 0, "weekDays" to utsArrayOf(
            "日",
            "一",
            "二",
            "三",
            "四",
            "五",
            "六"
        ), "calendarDays" to utsArrayOf<CalendarDay>(), "checkins" to utsArrayOf<CheckInRecord1>(), "selectedDate" to null as CalendarDay?, "showDayModal" to false, "isAnalyzing" to false, "showAiModal" to false, "aiAnalysisContent" to "", "reportDateStr" to "", "reasonStats" to utsArrayOf<ReasonStat>(), "closeBtnTop" to computed<Number>(fun(): Number {
            return uni_getSystemInfoSync().statusBarHeight + 15;
        }
        ), "selectedDateStr" to computed<String>(fun(): String {
            if (this.selectedDate == null) {
                return "";
            }
            return "" + this.selectedDate!!.year + "\u5E74" + this.selectedDate!!.month + "\u6708" + this.selectedDate!!.day + "\u65E5";
        }
        ), "selectedDayRecords" to computed<UTSArray<CheckInRecord1>>(fun(): UTSArray<CheckInRecord1> {
            if (this.selectedDate == null) {
                return utsArrayOf();
            }
            val start = Date(this.selectedDate!!.year, this.selectedDate!!.month - 1, this.selectedDate!!.day).getTime();
            val end = start + 86400000;
            return this.checkins.filter(fun(r: CheckInRecord1): Boolean {
                return r.timestamp >= start && r.timestamp < end;
            }
            ).sort(fun(a, b): Number {
                return b.timestamp - a.timestamp;
            }
            );
        }
        ));
    }
    override fun `$initMethods`() {
        this.startAiAnalysis = fun(): UTSPromise<Unit> {
            suspend fun async(): Unit {
                if (this.checkins.length < 3) {
                    uni_showToast(ShowToastOptions(title = "数据太少，再坚持打卡几次吧", icon = "none"));
                    return;
                }
                this.isAnalyzing = true;
                uni_showLoading(ShowLoadingOptions(title = "鹿师傅思考中..."));
                try {
                    val result = await(analyzeCheckIns(this.checkins));
                    if (result.success) {
                        this.aiAnalysisContent = result.content;
                        val d = Date();
                        this.reportDateStr = "" + d.getFullYear() + "/" + (d.getMonth() + 1) + "/" + d.getDate() + " " + d.getHours().toString().padStart(2, "0") + ":" + d.getMinutes().toString().padStart(2, "0");
                        this.showAiModal = true;
                    } else {
                        uni_showToast(ShowToastOptions(title = result.content, icon = "none"));
                    }
                }
                 catch (e: Throwable) {
                    uni_showToast(ShowToastOptions(title = "分析出错了", icon = "none"));
                }
                 finally{
                    this.isAnalyzing = false;
                    uni_hideLoading();
                }
            }
            return UTSPromise(fun(resolve, reject) {
                kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                    try {
                        val result = async();
                        resolve(result);
                    }
                     catch (e: Throwable) {
                        reject(e);
                    }
                }
                ;
            }
            );
        }
        ;
        this.closeAiModal = fun() {
            this.showAiModal = false;
        }
        ;
        this.formatTime = fun(timestamp: Number): String {
            val date = Date(timestamp);
            val hours = date.getHours().toString().padStart(2, "0");
            val minutes = date.getMinutes().toString().padStart(2, "0");
            return "" + hours + ":" + minutes;
        }
        ;
        this.loadStats = fun() {
            val data = uni_getStorageSync("lulema_checkins_v2");
            this.checkins = utsArrayOf();
            if (UTSArray.isArray(data)) {
                val rawList = data as UTSArray<Any>;
                this.checkins = rawList.map(fun(item): CheckInRecord1 {
                    val obj = item as UTSJSONObject;
                    return CheckInRecord1(timestamp = obj.getNumber("timestamp"), reason = obj.getString("reason"));
                });
            } else {
                val oldData = uni_getStorageSync("lulema_checkins");
                if (UTSArray.isArray(oldData)) {
                    val oldTimestamps = oldData as UTSArray<Number>;
                    this.checkins = oldTimestamps.map(fun(ts): CheckInRecord1 {
                        return (CheckInRecord1(timestamp = ts, reason = ""));
                    }
                    );
                }
            }
            this.totalCount = this.checkins.length;
            val now = Date();
            val startOfDay = Date(now.getFullYear(), now.getMonth(), now.getDate()).getTime();
            this.todayCount = this.checkins.filter(fun(r: CheckInRecord1): Boolean {
                return r.timestamp >= startOfDay;
            }
            ).length;
            this.calculateStreak();
            this.calculateReasons();
            this.generateCalendar();
        }
        ;
        this.calculateReasons = fun() {
            val stats = Map<String, Number>();
            var totalWithReason: Number = 0;
            this.checkins.forEach(fun(record){
                val reason = record.reason || "未记录";
                val count = stats.get(reason) || 0;
                stats.set(reason, count + 1);
                totalWithReason++;
            }
            );
            val result: UTSArray<ReasonStat> = utsArrayOf();
            stats.forEach(fun(count, reason){
                result.push(ReasonStat(reason = reason, count = count, percentage = if (totalWithReason > 0) {
                    Math.round((count / totalWithReason) * 100);
                } else {
                    0;
                }
                ));
            }
            );
            this.reasonStats = result.sort(fun(a, b){
                return b.count - a.count;
            }
            );
        }
        ;
        this.calculateStreak = fun() {
            if (this.checkins.length === 0) {
                this.maxStreak = 0;
                return;
            }
            val sorted = this.checkins.sort(fun(a, b): Number {
                return a.timestamp - b.timestamp;
            }
            );
            val uniqueDays = Set<String>();
            sorted.forEach(fun(r){
                val d = Date(r.timestamp);
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
            dayTimestamps.sort(fun(a, b): Number {
                return a - b;
            }
            );
            var currentStreak: Number = 0;
            var maxStreak: Number = 0;
            if (dayTimestamps.length > 0) {
                currentStreak = 1;
                maxStreak = 1;
                run {
                    var i: Number = 1;
                    while(i < dayTimestamps.length){
                        val diff = dayTimestamps[i] - dayTimestamps[i - 1];
                        if (diff < 86400000 * 1.5 && diff > 86400000 * 0.5) {
                            currentStreak++;
                        } else {
                            currentStreak = 1;
                        }
                        if (currentStreak > maxStreak) {
                            maxStreak = currentStreak;
                        }
                        i++;
                    }
                }
            }
            this.maxStreak = maxStreak;
            this.currentStreak = currentStreak;
        }
        ;
        this.changeMonth = fun(delta: Number) {
            var year = this.currentYear;
            var month = this.currentMonth + delta;
            if (month > 12) {
                year++;
                month = 1;
            } else if (month < 1) {
                year--;
                month = 12;
            }
            this.currentYear = year;
            this.currentMonth = month;
            this.generateCalendar();
        }
        ;
        this.generateCalendar = fun() {
            this.calendarDays = utsArrayOf();
            val year = this.currentYear;
            val month = this.currentMonth - 1;
            val firstDayOfMonth = Date(year, month, 1);
            val lastDayOfMonth = Date(year, month + 1, 0);
            val daysInMonth = lastDayOfMonth.getDate();
            val startDayOfWeek = firstDayOfMonth.getDay();
            val prevMonthLastDay = Date(year, month, 0).getDate();
            run {
                var i = startDayOfWeek - 1;
                while(i >= 0){
                    this.calendarDays.push(CalendarDay(day = prevMonthLastDay - i, month = month, year = if (month === 0) {
                        year - 1;
                    } else {
                        year;
                    }
                    , isCurrentMonth = false, count = 0, timestamp = 0, isToday = false));
                    i--;
                }
            }
            val now = Date();
            val todayYear = now.getFullYear();
            val todayMonth = now.getMonth();
            val todayDate = now.getDate();
            run {
                var i: Number = 1;
                while(i <= daysInMonth){
                    val currentDayStart = Date(year, month, i).getTime();
                    val currentDayEnd = Date(year, month, i + 1).getTime();
                    val count = this.checkins.filter(fun(r: CheckInRecord1): Boolean {
                        return r.timestamp >= currentDayStart && r.timestamp < currentDayEnd;
                    }
                    ).length;
                    val isToday = (year === todayYear && month === todayMonth && i === todayDate);
                    this.calendarDays.push(CalendarDay(day = i, month = month + 1, year = year, isCurrentMonth = true, count = count, timestamp = currentDayStart, isToday = isToday));
                    i++;
                }
            }
            val remainingCells = 42 - this.calendarDays.length;
            run {
                var i: Number = 1;
                while(i <= remainingCells){
                    this.calendarDays.push(CalendarDay(day = i, month = month + 2, year = if (month === 11) {
                        year + 1;
                    } else {
                        year;
                    }
                    , isCurrentMonth = false, count = 0, timestamp = 0, isToday = false));
                    i++;
                }
            }
        }
        ;
        this.selectDate = fun(item: CalendarDay) {
            this.selectedDate = item;
            this.showDayModal = true;
        }
        ;
        this.closeDayModal = fun() {
            this.showDayModal = false;
        }
        ;
        this.isSameDay = fun(d1: CalendarDay?, d2: CalendarDay): Boolean {
            if (!d1) {
                return false;
            }
            return d1.day === d2.day && d1.month === d2.month && d1.year === d2.year;
        }
        ;
        this.goToSettings = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/settings/settings"));
        }
        ;
    }
    open lateinit var startAiAnalysis: () -> Unit;
    open lateinit var closeAiModal: () -> Unit;
    open lateinit var formatTime: (timestamp: Number) -> String;
    open lateinit var loadStats: () -> Unit;
    open lateinit var calculateReasons: () -> Unit;
    open lateinit var calculateStreak: () -> Unit;
    open lateinit var changeMonth: (delta: Number) -> Unit;
    open lateinit var generateCalendar: () -> Unit;
    open lateinit var selectDate: (item: CalendarDay) -> Unit;
    open lateinit var closeDayModal: () -> Unit;
    open lateinit var isSameDay: (d1: CalendarDay?, d2: CalendarDay) -> Boolean;
    open lateinit var goToSettings: () -> Unit;
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
                return utsMapOf("content" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "backgroundImage" to "linear-gradient(180deg, #f0f4ff 0%, #ffffff 100%)", "paddingTop" to 50, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20)), "privacy-card" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "backgroundImage" to "linear-gradient(135deg, #e0f7fa 0%, #ffffff 100%)", "borderRadius" to 16, "marginBottom" to 30, "boxShadow" to "0 4px 12px rgba(0, 150, 136, 0.1)", "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "rgba(0,150,136,0.1)")), "privacy-icon-box" to padStyleMapOf(utsMapOf("width" to 48, "height" to 48, "borderRadius" to 24, "backgroundColor" to "rgba(0,150,136,0.1)", "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginRight" to 15)), "privacy-icon" to padStyleMapOf(utsMapOf("fontSize" to 24)), "privacy-content" to padStyleMapOf(utsMapOf("flex" to 1, "display" to "flex", "flexDirection" to "column")), "privacy-title" to padStyleMapOf(utsMapOf("fontSize" to 18, "fontWeight" to "bold", "color" to "#00796b", "marginBottom" to 4)), "privacy-desc" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#555555", "lineHeight" to 1.4)), "settings-btn" to padStyleMapOf(utsMapOf("width" to 40, "height" to 40, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderRadius" to 20, "backgroundColor" to "rgba(255,255,255,0.5)", "marginLeft" to 10, "backgroundColor:active" to "rgba(0,0,0,0.05)")), "settings-icon" to padStyleMapOf(utsMapOf("fontSize" to 20)), "stats-card" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "borderRadius" to 20, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "boxShadow" to "0 8px 20px rgba(0, 0, 0, 0.03)", "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "rgba(0,0,0,0.02)", "display" to "flex", "flexDirection" to "column", "marginBottom" to 20)), "stats-row" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-around", "alignItems" to "center", "paddingBottom" to 5)), "stat-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "minWidth" to 80)), "stat-num" to padStyleMapOf(utsMapOf("fontSize" to 24, "fontWeight" to "bold", "color" to "#333333", "marginBottom" to 4)), "stat-label" to padStyleMapOf(utsMapOf("fontSize" to 12, "color" to "#888888")), "calendar-card" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "borderRadius" to 20, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "boxShadow" to "0 8px 20px rgba(0, 0, 0, 0.03)", "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "rgba(0,0,0,0.02)", "display" to "flex", "flexDirection" to "column", "marginBottom" to 20)), "calendar-header" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "marginBottom" to 20, "paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10)), "month-switch" to padStyleMapOf(utsMapOf("paddingTop" to 5, "paddingRight" to 10, "paddingBottom" to 5, "paddingLeft" to 10)), "arrow-text" to padStyleMapOf(utsMapOf("fontSize" to 18, "color" to "#007aff")), "current-date" to padStyleMapOf(utsMapOf("fontSize" to 16, "fontWeight" to "bold", "color" to "#333333")), "week-row" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-around", "marginBottom" to 15)), "week-item" to padStyleMapOf(utsMapOf("fontSize" to 13, "color" to "#999999", "width" to "14.28%", "textAlign" to "center")), "days-grid" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap")), "day-item" to padStyleMapOf(utsMapOf("width" to "14.28%", "height" to 40, "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "position" to "relative", "marginBottom" to 8, "borderRadius" to 10, "transitionProperty" to "backgroundColor", "transitionDuration" to "0.2s", "backgroundColor:active" to "#f0f0f0")), "day-num" to utsMapOf("" to utsMapOf("fontSize" to 15, "color" to "#333333", "zIndex" to 1), ".not-current " to utsMapOf("color" to "#eeeeee"), ".today " to utsMapOf("color" to "#007aff", "fontWeight" to "bold"), ".selected " to utsMapOf("color" to "#ffffff"), ".has-checkin " to utsMapOf("fontWeight" to "bold")), "checkin-dot" to utsMapOf("" to utsMapOf("width" to 4, "height" to 4, "borderRadius" to 2, "backgroundColor" to "#007aff", "position" to "absolute", "bottom" to 6), ".selected " to utsMapOf("backgroundColor" to "#ffffff")), "today" to padStyleMapOf(utsMapOf("backgroundColor" to "#f0f4ff", "color" to "#007aff")), "selected" to padStyleMapOf(utsMapOf("backgroundColor" to "#007aff", "boxShadow" to "0 4px 10px rgba(0, 122, 255, 0.3)")), "calendar-footer" to padStyleMapOf(utsMapOf("marginTop" to 15, "display" to "flex", "justifyContent" to "center", "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#f5f5f5", "paddingTop" to 15)), "footer-tip" to padStyleMapOf(utsMapOf("fontSize" to 12, "color" to "#cccccc")), "analysis-card" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "borderRadius" to 20, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "boxShadow" to "0 8px 20px rgba(0, 0, 0, 0.03)", "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "rgba(0,0,0,0.02)", "display" to "flex", "flexDirection" to "column", "marginBottom" to 20)), "card-title" to padStyleMapOf(utsMapOf("fontSize" to 18, "fontWeight" to "bold", "color" to "#333333", "marginBottom" to 20)), "chart-row" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginBottom" to 16)), "chart-label" to padStyleMapOf(utsMapOf("fontSize" to 14, "color" to "#666666", "width" to 60, "whiteSpace" to "nowrap", "overflow" to "hidden", "textOverflow" to "ellipsis")), "progress-container" to padStyleMapOf(utsMapOf("flex" to 1, "height" to 8, "backgroundColor" to "#f5f7fa", "borderRadius" to 4, "marginTop" to 0, "marginRight" to 12, "marginBottom" to 0, "marginLeft" to 12, "overflow" to "hidden")), "progress-bar" to padStyleMapOf(utsMapOf("height" to "100%", "backgroundImage" to "linear-gradient(90deg, #4facfe, #00f2fe)", "borderRadius" to 4)), "chart-value" to padStyleMapOf(utsMapOf("fontSize" to 14, "color" to "#333333", "fontWeight" to "bold", "width" to 40, "textAlign" to "right")), "modal-overlay" to padStyleMapOf(utsMapOf("position" to "fixed", "top" to 0, "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "rgba(0,0,0,0.5)", "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "zIndex" to 1000, "backdropFilter" to "blur(3px)")), "modal-content" to padStyleMapOf(utsMapOf("width" to "80%", "backgroundColor" to "#ffffff", "borderRadius" to 20, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "display" to "flex", "flexDirection" to "column", "boxShadow" to "0 10px 30px rgba(0, 0, 0, 0.2)", "animation" to "modalPop 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275)", "position" to "relative")), "modal-header" to padStyleMapOf(utsMapOf("display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginBottom" to 15, "paddingBottom" to 15, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f0f0f0")), "modal-title" to padStyleMapOf(utsMapOf("fontSize" to 18, "fontWeight" to "bold", "color" to "#333333")), "modal-close" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 15, "right" to 15, "fontSize" to 28, "color" to "#999999", "paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5, "lineHeight" to 1, "zIndex" to 10)), "records-list" to padStyleMapOf(utsMapOf("maxHeight" to 300, "width" to "100%")), "empty-state" to padStyleMapOf(utsMapOf("paddingTop" to 30, "paddingRight" to 0, "paddingBottom" to 30, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "empty-text" to padStyleMapOf(utsMapOf("color" to "#999999", "fontSize" to 14)), "record-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 12, "paddingRight" to 0, "paddingBottom" to 12, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f9f9f9")), "record-time-box" to padStyleMapOf(utsMapOf("backgroundColor" to "#f0f4ff", "paddingTop" to 4, "paddingRight" to 10, "paddingBottom" to 4, "paddingLeft" to 10, "borderRadius" to 6, "marginRight" to 15)), "record-time" to padStyleMapOf(utsMapOf("color" to "#007aff", "fontSize" to 14, "fontWeight" to "bold")), "record-info" to padStyleMapOf(utsMapOf("flex" to 1)), "record-reason" to padStyleMapOf(utsMapOf("color" to "#333333", "fontSize" to 15)), "ai-entry-btn" to padStyleMapOf(utsMapOf("marginTop" to 15, "backgroundImage" to "linear-gradient(90deg, #6c5ce7, #a29bfe)", "borderRadius" to 12, "paddingTop" to 12, "paddingRight" to 20, "paddingBottom" to 12, "paddingLeft" to 20, "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "position" to "relative", "boxShadow" to "0 4px 15px rgba(108, 92, 231, 0.3)", "transitionProperty" to "transform", "transitionDuration" to "0.2s", "transform:active" to "scale(0.98)")), "ai-icon" to padStyleMapOf(utsMapOf("fontSize" to 20, "marginRight" to 8)), "ai-text" to padStyleMapOf(utsMapOf("color" to "#ffffff", "fontSize" to 16, "fontWeight" to "bold", "letterSpacing" to 1)), "ai-badge" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to -8, "right" to -5, "backgroundColor" to "#ff7675", "color" to "#ffffff", "fontSize" to 10, "fontWeight" to "bold", "paddingTop" to 2, "paddingRight" to 6, "paddingBottom" to 2, "paddingLeft" to 6, "borderRadius" to 8, "boxShadow" to "0 2px 5px rgba(0,0,0,0.2)")), "ai-report-card" to padStyleMapOf(utsMapOf("backgroundColor" to "#fcfcfc", "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "#e0e0e0", "paddingTop" to 0, "paddingRight" to 0, "paddingBottom" to 0, "paddingLeft" to 0, "overflow" to "hidden", "display" to "flex", "flexDirection" to "column", "height" to "80%", "width" to "90%", "borderRadius" to 0)), "report-stripe" to padStyleMapOf(utsMapOf("height" to 8, "width" to "100%", "marginTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "report-close" to padStyleMapOf(utsMapOf("right" to 15, "color" to "#333333", "zIndex" to 20, "backgroundColor" to "rgba(255,255,255,0.8)", "width" to 32, "height" to 32, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "fontSize" to 24, "boxShadow" to "0 2px 8px rgba(0,0,0,0.1)")), "report-header" to padStyleMapOf(utsMapOf("paddingTop" to 25, "paddingRight" to 20, "paddingBottom" to 15, "paddingLeft" to 20, "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "backgroundColor" to "#f9f9f9")), "report-title" to padStyleMapOf(utsMapOf("fontSize" to 22, "color" to "#333333", "marginBottom" to 8, "letterSpacing" to 1)), "report-date" to padStyleMapOf(utsMapOf("fontSize" to 12, "color" to "#888888", "fontFamily" to "monospace")), "report-divider" to padStyleMapOf(utsMapOf("height" to 2, "backgroundImage" to "linear-gradient(to right, #ccc 50%, rgba(255, 255, 255, 0) 0%)", "backgroundPosition" to "bottom", "backgroundSize" to "10px 2px", "backgroundRepeat" to "repeat-x", "marginTop" to 0, "marginRight" to 20, "marginBottom" to 0, "marginLeft" to 20)), "report-body" to padStyleMapOf(utsMapOf("flex" to 1, "paddingTop" to 20, "paddingRight" to 25, "paddingBottom" to 20, "paddingLeft" to 25, "backgroundColor" to "#ffffff", "width" to "100%", "boxSizing" to "border-box")), "report-text" to padStyleMapOf(utsMapOf("fontSize" to 16, "color" to "#444444", "lineHeight" to 1.8, "fontFamily" to "sans-serif")), "report-footer" to padStyleMapOf(utsMapOf("paddingTop" to 15, "paddingRight" to 20, "paddingBottom" to 15, "paddingLeft" to 20, "display" to "flex", "justifyContent" to "space-between", "alignItems" to "flex-end", "backgroundColor" to "#f9f9f9", "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#eeeeee")), "report-signature" to padStyleMapOf(utsMapOf("fontFamily" to "Cursive, sans-serif", "fontSize" to 14, "color" to "#333333", "fontWeight" to "bold", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#333333", "paddingBottom" to 2)), "report-stamp" to padStyleMapOf(utsMapOf("width" to 60, "height" to 60, "borderWidth" to 2, "borderStyle" to "solid", "borderColor" to "#ff5252", "display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "transform" to "rotate(-15deg)", "opacity" to 0.8)), "stamp-text" to padStyleMapOf(utsMapOf("color" to "#ff5252", "fontSize" to 10, "fontWeight" to "bold")), "stamp-sub" to padStyleMapOf(utsMapOf("color" to "#ff5252", "fontSize" to 8)), "@FONT-FACE" to utsMapOf("0" to utsMapOf()), "@TRANSITION" to utsMapOf("day-item" to utsMapOf("property" to "backgroundColor", "duration" to "0.2s"), "ai-entry-btn" to utsMapOf("property" to "transform", "duration" to "0.2s")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}

/**
 * 定义常量，避免魔法字符
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/27 下午5:40
 * @since 1.0 Created by lipangeng on 2017/5/27 下午5:40. Email:lipg@outlook.com.
 */
var Cloud_Constant = {};
// 定义绑定操作按钮常用的选择器
$(function ($) {
    Cloud_Constant.bindings = {};
    var finders = Cloud_Constant.bindings.finder = {};
    // 初始化表单选择器
    finders.form = {};
    // 绑定提交按钮的class选择器
    finders.form.submit = '.cloud_form_submit';
    // 绑定需确认的表单提交按钮的class选择器
    finders.form.submitConfirm = '.cloud_form_submit_confirm';
}(jQuery));

/**
 *
 * 应用的Common 工具类
 *
 * 将方法封装，提供更好的隔离性
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/27 下午5:32
 * @since 1.0 Created by lipangeng on 2017/5/27 下午5:32. Email:lipg@outlook.com.
 */
var Cloud_Common = (function ($) {
    // 真正的初始化方法
    function Init_App() {
        // 初始化全局表单提交触发器
        $('form').on('click', Cloud_Constant.bindings.finder.form.submit, function () {
            bind_Form_Submit_Button(this);
        });
        // 初始化全局表单提交触发器
        $('form').on('click', Cloud_Constant.bindings.finder.form.submitConfirm, function () {
            bind_Form_Submit_Submit_Button(this);
        });
    }

    // 绑定全局的提交表单class
    function bind_Form_Submit_Button(obj) {
        // 将对象转换为Jquery对象
        if (!(obj instanceof jQuery)) {
            obj = $(obj);
        }
        obj.parents('form').submit();
    }

    // 绑定全局的提交表单class
    function bind_Form_Submit_Submit_Button(obj) {
        // 将对象转换为Jquery对象
        if (!(obj instanceof jQuery)) {
            obj = $(obj);
        }
        Cloud_Common.Notification.Confirm.FormSubmit(obj.data('title'), obj.data('content'), obj.parents('form'));
    }

    // 初始化
    $(function () {
        Init_App();
    });
    // 不对外暴露方法
    return {
        // 字符串工具
        Strings: {
            /** @return {boolean} */
            NotBlank: function (string) {
                return string !== undefined && string !== '';
            },
            /** @return {boolean} */
            IsBlank: function (string) {
                return string === undefined || $.trim(string) === '';
            }
        },
        // 通知工具
        Notification: {
            Toastr: {
                SuccessAutoClose: function (title, text, code, timer) {
                    toastr.success(text || title,
                                   (Cloud_Common.Strings.NotBlank(text) &&
                                    Cloud_Common.Strings.NotBlank(title) ?
                                    title : '操作成功') + '(' + code + ')',
                                   {"timeOut": timer || 2000, "progressBar": true}
                    );
                }
            },
            Alert: {
                SuccessAutoClose: function (title, text, code, timer) {
                    swal({
                             title: (Cloud_Common.Strings.NotBlank(text) &&
                                     Cloud_Common.Strings.NotBlank(title) ?
                                     title : '操作成功') + '(' + code + ')',
                             text: text || title,
                             type: 'success',
                             timer: timer || 3000
                         });
                },
                ErrorAutoClose: function (title, text, code, timer) {
                    swal({
                             title: (Cloud_Common.Strings.NotBlank(text) &&
                                     Cloud_Common.Strings.NotBlank(title) ?
                                     title : '操作失败') + '(' + code + ')',
                             text: text || title,
                             type: 'error',
                             timer: timer || 5000
                         });
                },
                Error: function (title, text, code) {
                    swal({
                             title: (Cloud_Common.Strings.NotBlank(text) &&
                                     Cloud_Common.Strings.NotBlank(title) ?
                                     title : '操作失败') + '(' + code + ')',
                             text: text || title,
                             type: 'error'
                         });
                }
            },
            Confirm: {
                FormSubmit: function (title, content, form) {
                    swal({
                             title: (Cloud_Common.Strings.NotBlank(content) &&
                                     Cloud_Common.Strings.NotBlank(title) ?
                                     title : '确认操作'),
                             text: content || title,
                             type: 'warning',
                             showCancelButton: true,
                             confirmButtonColor: "#DD6B55",
                             confirmButtonText: "确认",
                             cancelButtonText: "取消"
                         }).then(function () {
                        // 将对象转换为Jquery对象
                        if (!(form instanceof jQuery)) {
                            form = $(form);
                        }
                        form.submit();
                    });
                }
            }
        },
        // Url工具
        Url: {
            getParams: function () {
                var _url = location.search;
                var _request = {};
                if (_url.indexOf("?") !== -1) {
                    var str = _url.substr(1);
                    var strs = str.split("&");
                    for (var i = 0; i < strs.length; i++) {
                        _request[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
                    }
                }
                return _request;
            }
        }

    };
}(jQuery));

<#-- @ftlvariable name="CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE" type="com.ilemontech.ldcos.cloud.model.NotificationModel" -->
<!-- jQuery 2.2.3 -->
<script src="js/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="js/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="js/bootstrap.min.js"></script>
<!-- sweetalert -->
<script src="js/sweetalert/sweetalert.min.js"></script>
<!-- toastr notification -->
<script src="js/toastr/toastr.min.js"></script>
<!-- AdminLTE App -->
<script src="js/app.min.js"></script>
<!-- Cloud App -->
<script src="js/cloud/Constant.min.js"></script>
<script src="js/cloud/Common.min.js"></script>
<script src="js/cloud/App.min.js"></script>
<script src="js/cloud/Api.min.js"></script>
<#if CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE??>
<!-- 通知处理 -->
<script type="text/javascript">
    $(function () {
        // 注入参数
        let _title = '${(CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE.title!"")?js_string}';
        let _text = '${(CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE.content!"")?js_string}';
        let _type = '${(CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE.type!"toastr")?js_string}';
        let _status = '${(CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE.status!"sucess")?js_string}';
        let _code = '${(CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE.code!"200")?js_string}';
        switch (_type) {
            case 'toastr':
                switch (_status) {
                    case 'success':
                        Cloud_Common.Notification.Toastr.SuccessAutoClose(_title, _text, _code);
                        break;
                    default:
                        console.error('通知状态:' + _status + '在Toastr中不被支持');
                }
                break;
            case 'alert':
                switch (_status) {
                    case 'success':
                        Cloud_Common.Notification.Alert.SuccessAutoClose(_title, _text, _code);
                        break;
                    case 'error':
                        Cloud_Common.Notification.Alert.Error(_title, _text, _code);
                        break;
                    default:
                        console.error('通知状态:' + _status + '在Alert中不被支持');
                }
                break;
            default:
                console.error('通知类型:' + _type + '不被支持');
        }
    });
</script>
</#if>
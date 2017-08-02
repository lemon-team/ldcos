<!-- 保证check一致 -->
<script src="js/icheck.min.js"></script>
<script type="text/javascript">
    // iCheck
    $(function () {
        // 保证单选框在各种系统一致
        $('input:checkbox').iCheck({
                                       checkboxClass: 'icheckbox_square-blue',
                                       radioClass: 'iradio_square-blue',
                                       increaseArea: '20%' // optional
                                   });
    })
</script>
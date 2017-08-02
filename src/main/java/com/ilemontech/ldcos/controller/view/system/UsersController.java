package com.ilemontech.ldcos.controller.view.system;

import com.ilemontech.ldcos.common.BeanUtils;
import com.ilemontech.ldcos.common.ServletUtils;
import com.ilemontech.ldcos.common.SessionUtils;
import com.ilemontech.ldcos.constant.configure.SpringConstant;
import com.ilemontech.ldcos.constant.model.NotificationConstant;
import com.ilemontech.ldcos.entity.UserEntity;
import com.ilemontech.ldcos.model.NotificationModel;
import com.ilemontech.ldcos.model.PageModel;
import com.ilemontech.ldcos.model.form.system.users.AddUserForm;
import com.ilemontech.ldcos.model.form.system.users.EditUserForm;
import com.ilemontech.ldcos.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 用户管理
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/27 下午4:09
 * @since 1.0 Created by lipangeng on 2017/5/27 下午4:09. Email:lipg@outlook.com.
 */
@Controller
@RequestMapping("system/users")
public class UsersController {
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
    private static final String TEMPLATE_PATH = "system/users/";
    @Autowired
    private UserService userService;

    /**
     * 用户管理主页
     *
     * @since 1.0 Created by lipangeng on 2017/5/27 下午4:10. Email:lipg@outlook.com.
     */
    @RequestMapping({"", "index"})
    public String index(Model model) {
        Page<UserEntity> users = userService.findAllUser(new UserEntity(), new RowBounds(1, 0), false);
        model.addAttribute("usersCount", users.getTotal());
        return TEMPLATE_PATH + "index";
    }

    /**
     * 用户列表
     *
     * @since 1.0 Created by lipangeng on 2017/5/27 下午4:12. Email:lipg@outlook.com.
     */
    @RequestMapping("list")
    public String list(Model model, PageModel page, HttpServletRequest request) {
        Page<UserEntity> users = userService.findAllUser(new UserEntity(), page.toRowBounds(), true);
        model.addAttribute("users", new PageInfo<>(users, page.getNavigatePages()));
        return TEMPLATE_PATH + "list";
    }

    /**
     * 添加新用户
     *
     * @since 1.0 Created by lipangeng on 2017/5/31 下午3:01. Email:lipg@outlook.com.
     */
    @RequestMapping(value = "user/add", method = RequestMethod.GET)
    public String addUser() {
        return TEMPLATE_PATH + "user/add";
    }

    /**
     * 实际添加用户的方法
     *
     * @since 1.0 Created by lipangeng on 2017/5/31 下午4:41. Email:lipg@outlook.com.
     */
    @RequestMapping(value = "user/add", method = {RequestMethod.POST, RequestMethod.PUT})
    public String doAddUser(@Valid AddUserForm userForm,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            HttpServletRequest request) {
        // 异常处理
        if (bindingResult.hasErrors()) {
            logger.error("绑定数据失败，参数未通过验证。错误信息:{}", BeanUtils.getBindingsErrorsDetailStr(bindingResult));
            redirectAttributes.addFlashAttribute(NotificationConstant.CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE,
                                                 NotificationModel.errorAlert("无法添加用户",
                                                                              BeanUtils.getBindingsErrorsStr(bindingResult),
                                                                              NotificationConstant.CODE.BAD_REQUEST.getValue()));
            redirectAttributes.addFlashAttribute("user", userForm);
            return SpringConstant.CONTROLLER_REDIRECT + ServletUtils.RedirectSelfUri(request);
        }
        UserEntity user = userService.findByUserName(userForm.getUsername());
        // 保存用户
        try {
            Preconditions.checkArgument(user == null, "用户已经存在");
            boolean inserted = userService.insert(BeanUtils.copyProperties(userForm, user = new UserEntity()));
            Preconditions.checkState(inserted, "保存用户信息失败");
        } catch (Exception e) {
            logger.error("新增用户失败", e);
            // 弹出通知
            redirectAttributes.addFlashAttribute(NotificationConstant.CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE,
                                                 NotificationModel.errorAlert("添加用户失败",
                                                                              "添加用户发生错误,参考信息:" + e.getMessage(),
                                                                              NotificationConstant.CODE.SERVER_ERROR.getValue()));
            redirectAttributes.addFlashAttribute("user", userForm);
            return SpringConstant.CONTROLLER_REDIRECT + ServletUtils.RedirectSelfUri(request);
        }
        redirectAttributes.addFlashAttribute(NotificationConstant.CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE,
                                             NotificationModel.successToastr("新增用户",
                                                                             String.format("已为%s创建账号:%s",
                                                                                           user.getRealName(),
                                                                                           user.getUsername())));
        return SpringConstant.CONTROLLER_REDIRECT + "system/users/" + user.getId();
    }

    /**
     * 用户信息展示
     *
     * @since 1.0 Created by lipangeng on 2017/6/2 上午11:08. Email:lipg@outlook.com.
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String userInfo(Model model, @PathVariable("id") Long id) {
        UserEntity user = userService.findOne(id);
        Preconditions.checkNotNull(user, "用户不存在");
        model.addAttribute("user", user);
        return TEMPLATE_PATH + "user/info";
    }

    /**
     * 用户信息修改
     *
     * @since 1.0 Created by lipangeng on 2017/6/2 上午11:08. Email:lipg@outlook.com.
     */
    @RequestMapping(value = "user/{id}/edit", method = RequestMethod.GET)
    public String editUser(Model model, @RequestParam(name = "user", required = false) EditUserForm userForm, @PathVariable("id") Long id) {
        UserEntity user = userService.findOne(id);
        Preconditions.checkNotNull(user, "用户不存在");
        // 如果没有传user进来，则注入user对象
        if (userForm == null || userForm.getId() == null) {
            model.addAttribute("user", BeanUtils.copyProperties(user, userForm = userForm == null ? new EditUserForm() : userForm));
        }
        // 保证id的准确性
        userForm.setId(user.getId());
        return TEMPLATE_PATH + "user/edit";
    }

    /**
     * 用户信息修改
     *
     * @since 1.0 Created by lipangeng on 2017/6/2 上午11:08. Email:lipg@outlook.com.
     */
    @RequestMapping(value = "user/{id}/edit", method = {RequestMethod.POST, RequestMethod.PUT})
    public String doEditUser(Model model,
                             @PathVariable("id") Long id,
                             @Valid EditUserForm userForm,
                             BindingResult bindingResult,
                             RedirectAttributes attributes,
                             HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            attributes.addFlashAttribute(NotificationConstant.CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE,
                                         NotificationModel.errorAlert("更新用户信息",
                                                                      BeanUtils.getBindingsErrorsStr(bindingResult),
                                                                      NotificationConstant.CODE.BAD_REQUEST.getValue()));
            attributes.addFlashAttribute("user", userForm);
            return ServletUtils.RedirectSelfUri(request);
        }
        try {
            UserEntity user = userService.findOne(id);
            Preconditions.checkNotNull(user, "Id:" + id + "的用户不存在");
            // 判断是不是需要更新密码
            if (! Strings.isNullOrEmpty(userForm.getPassword())) {
                Preconditions.checkArgument(Objects.equal(userForm.getPassword(), userForm.getRepassword()), "两次输入的密码不一致");
                user.setPassword(userForm.getPassword());
                userService.updatePassword(user);
            }
            BeanUtils.copyProperties(userForm, user);
            user.setId(id);
            Preconditions.checkState(userService.updateUser(user));
            attributes.addFlashAttribute(NotificationConstant.CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE,
                                         NotificationModel.successToastr("更新用户信息", String.format("更新用户%s信息成功", user.getRealName())));
            return SpringConstant.CONTROLLER_REDIRECT + "system/users/user/" + id;
        } catch (Exception e) {
            logger.error("更新用户信息发生异常。", e);
            attributes.addFlashAttribute(NotificationConstant.CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE,
                                         NotificationModel.errorAlert("更新用户信息",
                                                                      "更新用户信息发生错误，参考信息:" + e.getMessage(),
                                                                      NotificationConstant.CODE.SERVER_ERROR.getValue()));
            attributes.addFlashAttribute("user", userForm);
            return ServletUtils.RedirectSelfUri(request);
        }
    }

    /**
     * 用户信息展示
     *
     * @since 1.0 Created by lipangeng on 2017/6/2 上午11:08. Email:lipg@outlook.com.
     */
    @RequestMapping(value = "user/{id}/delete", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public String delUser(@PathVariable("id") Long id, RedirectAttributes attributes) {
        try {
            // 检查是否删除自身账户
            Preconditions.checkState(! Objects.equal(id, SessionUtils.currentUserDetails().getId()), "无法删除自身账户");
            UserEntity user = userService.findOne(id);
            Preconditions.checkState(userService.deleteUser(id), "删除用户失败,发生未知错误");
            attributes.addFlashAttribute(NotificationConstant.CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE,
                                         NotificationModel.successToastr("删除用户", String.format("成功删除用户%s", user.getRealName())));
            return TEMPLATE_PATH + "system/users";
        } catch (Exception e) {
            logger.error("删除用户:" + id + "发生异常", e);
            attributes.addFlashAttribute(NotificationConstant.CLOUD_NOTIFICATION_CONTEXT_ATTRIBUTE,
                                         NotificationModel.errorAlert("删除用户",
                                                                      "删除用户失败，参考信息:" + e.getMessage(),
                                                                      NotificationConstant.CODE.SERVER_ERROR.getValue()));
            return SpringConstant.CONTROLLER_REDIRECT + "system/users";
        }
    }
}

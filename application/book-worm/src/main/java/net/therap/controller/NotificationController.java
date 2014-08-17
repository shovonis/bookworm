package net.therap.controller;

import net.therap.domain.Notification;
import net.therap.domain.User;
import net.therap.service.NotificationService;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/12/14.
 */

@Controller
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/notification/{receiverId}", method = RequestMethod.GET)
    public ModelAndView showAllNotification(@PathVariable int receiverId) {

        List<Notification> notificationList = notificationService.getAllNotification(receiverId);
        ModelAndView modelAndView = new ModelAndView("user/notification");
        modelAndView.addObject("notificationList", notificationList);

        return modelAndView;
    }

    @RequestMapping("/getSenderImage/{userId}")
    @ResponseBody
    public byte[] getProfilePicture(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        return user.getProfilePicture();
    }

    @RequestMapping(value = "/sendNotification", method = RequestMethod.POST)
    @ResponseBody
    public void sendNotification(@RequestParam("receiverId") int receiverId, @RequestParam("bookId") int bookId
            , @RequestParam("type") int type, @RequestParam("isSeen") boolean isSeen, HttpSession session) {

        User user = (User) session.getAttribute("user");
        notificationService.addNewNotification(user.getUserId(), receiverId, bookId, type, isSeen);
    }


    @RequestMapping(value = "/updateNotification", method = RequestMethod.POST)
    @ResponseBody
    public void updateNotification(@RequestParam("id") int notificationId, @RequestParam("receiverId") int receiverId,
                                   @RequestParam("bookId") int bookId, @RequestParam("type") int type,
                                   @RequestParam("isSeen") boolean isSeen, HttpSession session) {

        User user = (User) session.getAttribute("user");
        notificationService.updateAndInsertNotification(notificationId,
                user.getUserId(), receiverId, bookId, type, isSeen);
    }

    @RequestMapping(value = "/notification/getNotificationCounter", method = RequestMethod.GET)
    @ResponseBody
    public long getNotificationCounter(HttpSession session) {
        User user = (User) session.getAttribute("user");
        long total = notificationService.getUnseenNotification(user.getUserId());
        System.out.println("total = " + total);
        return total;
    }
}

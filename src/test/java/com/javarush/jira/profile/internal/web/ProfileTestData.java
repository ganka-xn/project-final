package com.javarush.jira.profile.internal.web;

import com.javarush.jira.MatcherFactory;
import com.javarush.jira.profile.ContactTo;
import com.javarush.jira.profile.ProfileTo;

import java.util.Collections;
import java.util.Set;

public class ProfileTestData {

    public static MatcherFactory.Matcher<ProfileTo> PROFILE_DTO_MATCHER =
            MatcherFactory.usingIgnoringFieldsComparator(ProfileTo.class, "user");

    public static final Long ADMIN_ID = 2L;
    public static final Long USER_ID = 1L;

    private static final String ASSIGNED = "assigned";
    private static final String THREE_DAYS_BEFORE_DEADLINE = "three_days_before_deadline";
    private static final String TWO_DAYS_BEFORE_DEADLINE = "two_days_before_deadline";
    private static final String ONE_DAY_BEFORE_DEADLINE = "one_day_before_deadline";
    private static final String DEADLINE = "deadline";
    private static final String OVERDUE = "overdue";

    private static final ContactTo USER_CONTACT_SKYPE = new ContactTo("skype", "userSkype");
    private static final ContactTo USER_CONTACT_MOBILE = new ContactTo("mobile", "+01234567890");
    private static final ContactTo USER_CONTACT_WEBSITE = new ContactTo("website", "user.com");

    private static final ContactTo USER_CONTACT_SKYPE_UPDATED = new ContactTo("skype", "newSkype");
    private static final ContactTo USER_CONTACT_MOBILE_UPDATED = new ContactTo("mobile", "+380987654321");
    private static final ContactTo USER_CONTACT_WEBSITE_UPDATED = new ContactTo("website", "new.com");
    private static final ContactTo USER_CONTACT_GITHUB_UPDATED = new ContactTo("github", "newGitHub");
    private static final ContactTo USER_CONTACT_TG_UPDATED = new ContactTo("tg", "newTg");
    private static final ContactTo USER_CONTACT_VK_UPDATED = new ContactTo("vk", "newVk");
    private static final ContactTo USER_CONTACT_LINKEDIN_UPDATED = new ContactTo("linkedin", "newLinkedin");

    private static final ContactTo ADMIN_CONTACT_GITHUB = new ContactTo("github", "adminGitHub");
    private static final ContactTo ADMIN_CONTACT_TG = new ContactTo("tg", "adminTg");
    private static final ContactTo ADMIN_CONTACT_VK = new ContactTo("vk", "adminVk");

    private static final ContactTo ADMIN_CONTACT_GITHUB_UPDATED = new ContactTo("github", "newAdminGitHub");
    private static final ContactTo ADMIN_CONTACT_TG_UPDATED = new ContactTo("tg", "newAdminTg");
    private static final ContactTo ADMIN_CONTACT_VK_UPDATED = new ContactTo("vk", "newAdminVk");
    private static final ContactTo ADMIN_CONTACT_SKYPE_UPDATED = new ContactTo("skype", "newAdminSkype");
    private static final ContactTo ADMIN_CONTACT_MOBILE_UPDATED = new ContactTo("mobile", "newAdminMobile");
    private static final ContactTo ADMIN_CONTACT_WEBSITE_UPDATED = new ContactTo("website", "newAdminWebsite");
    private static final ContactTo ADMIN_CONTACT_LINKEDIN_UPDATED = new ContactTo("linkedin", "newAdminLinkedin");

    public static final Set<String> USER_NOTIFICATIONS = Set.of(
            ASSIGNED,
            OVERDUE,
            DEADLINE
    );

    public static final Set<ContactTo> USER_CONTACTS = Set.of(
            USER_CONTACT_SKYPE,
            USER_CONTACT_MOBILE,
            USER_CONTACT_WEBSITE
    );

    public static final Set<String> USER_NOTIFICATIONS_UPDATED = Set.of(
            ASSIGNED,
            THREE_DAYS_BEFORE_DEADLINE,
            TWO_DAYS_BEFORE_DEADLINE,
            ONE_DAY_BEFORE_DEADLINE,
            DEADLINE,
            OVERDUE
    );

    public static final Set<ContactTo> USER_CONTACTS_UPDATED = Set.of(
            USER_CONTACT_SKYPE_UPDATED,
            USER_CONTACT_MOBILE_UPDATED,
            USER_CONTACT_WEBSITE_UPDATED,
            USER_CONTACT_GITHUB_UPDATED,
            USER_CONTACT_TG_UPDATED,
            USER_CONTACT_VK_UPDATED,
            USER_CONTACT_LINKEDIN_UPDATED
    );

    public static final Set<String> ADMIN_NOTIFICATIONS = Set.of(
            TWO_DAYS_BEFORE_DEADLINE,
            ONE_DAY_BEFORE_DEADLINE,
            THREE_DAYS_BEFORE_DEADLINE
    );

    public static final Set<ContactTo> ADMIN_CONTACTS = Set.of(
            ADMIN_CONTACT_GITHUB,
            ADMIN_CONTACT_TG,
            ADMIN_CONTACT_VK
    );

    public static final Set<String> ADMIN_NOTIFICATIONS_UPDATED = Set.of(
            THREE_DAYS_BEFORE_DEADLINE,
            TWO_DAYS_BEFORE_DEADLINE,
            ONE_DAY_BEFORE_DEADLINE,
            DEADLINE
    );

    public static final Set<ContactTo> ADMIN_CONTACTS_UPDATED = Set.of(
            ADMIN_CONTACT_GITHUB_UPDATED,
            ADMIN_CONTACT_TG_UPDATED,
            ADMIN_CONTACT_VK_UPDATED,
            ADMIN_CONTACT_SKYPE_UPDATED,
            ADMIN_CONTACT_MOBILE_UPDATED,
            ADMIN_CONTACT_WEBSITE_UPDATED,
            ADMIN_CONTACT_LINKEDIN_UPDATED
    );

    public static ProfileTo ADMIN_PROFILE_DTO = new ProfileTo(
            ADMIN_ID,
            ADMIN_NOTIFICATIONS,
            ADMIN_CONTACTS
    );

    public static ProfileTo USER_PROFILE_DTO = new ProfileTo(
            USER_ID,
            USER_NOTIFICATIONS,
            USER_CONTACTS
    );

    public static ProfileTo getUpdatedUserDTO() {
        return new ProfileTo(
                USER_ID,
                USER_NOTIFICATIONS_UPDATED,
                USER_CONTACTS_UPDATED
        );
    }

    public static ProfileTo getUpdatedAdminDTO() {
        return new ProfileTo(
                ADMIN_ID,
                ADMIN_NOTIFICATIONS_UPDATED,
                ADMIN_CONTACTS_UPDATED
        );
    }

    public static ProfileTo getInvalidDTO() {
        return new ProfileTo(null,
                Set.of(""),
                Set.of(new ContactTo("skype", "")));
    }

    public static ProfileTo getWithUnknownNotificationDTO() {
        return new ProfileTo(null,
                Set.of("WrongNotification"),
                Collections.emptySet());
    }

    public static ProfileTo getWithUnknownContactDTO() {
        return new ProfileTo(null,
                Collections.emptySet(),
                Set.of(new ContactTo("WrongContactCode", "contact")));
    }

    public static ProfileTo getWithContactHtmlUnsafeDTO() {
        return new ProfileTo(null,
                Collections.emptySet(),
                Set.of(new ContactTo("tg", "<script>alert(123)</script>")));
    }
}
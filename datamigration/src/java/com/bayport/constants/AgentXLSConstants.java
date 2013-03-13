package com.bayport.constants;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: JAVADEV05
 * Date: 2013/03/07
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class AgentXLSConstants {

    public static final int agentImportStart = 8;

    public static final Map<Integer, String> agentColumnsMap = new HashMap<Integer, String>();

    static {

        agentColumnsMap.put(0, "uploadedAgentSheetLineNumber");
        agentColumnsMap.put(1, "agentCode");
        agentColumnsMap.put(2, "agentLookUpType.lookUpTypeValue");
        agentColumnsMap.put(3, "appointmentDate");
        agentColumnsMap.put(4, "active");
        agentColumnsMap.put(5, "eligibleForCommission");
        agentColumnsMap.put(6, "outletName");
    }

    public static final Map<Integer, String> personColumnsMap = new HashMap<Integer, String>();

    static {
        personColumnsMap.put(11, "lastName");
        personColumnsMap.put(12, "firstName");
        personColumnsMap.put(13, "middleName");
        personColumnsMap.put(14, "titleLookUpValue.lookUpTypeValue");
        personColumnsMap.put(15, "suffix");
        personColumnsMap.put(16, "nickname");
        personColumnsMap.put(17, "birthDate");
        personColumnsMap.put(18, "motherMaidenName");
        personColumnsMap.put(19, "maritalStatusLookUpValue.lookUpTypeValue");
        personColumnsMap.put(20, "idNumber");
        personColumnsMap.put(21, "passportNumber");
        personColumnsMap.put(22, "passportExpireDate");
        personColumnsMap.put(23, "totalYearsWorkExperience");
        personColumnsMap.put(24, "dependants");
        personColumnsMap.put(25, "comments");
        personColumnsMap.put(26, "genderLookUpValue.lookUpTypeValue");
        personColumnsMap.put(27, "children");
        personColumnsMap.put(28, "educationLevelLookUpValue.lookUpTypeValue");
        personColumnsMap.put(29, "occupationStatusLookUpValue.lookUpTypeValue");
        personColumnsMap.put(30, "occupationLookUpValue.lookUpTypeValue");
        personColumnsMap.put(31, "idTypeLookUpValue.lookUpTypeValue");
        personColumnsMap.put(32, "idIssueDate");
        personColumnsMap.put(33, "idIssueCityLookUpValue.lookUpTypeValue");
        personColumnsMap.put(34, "birthCityLookUpValue.lookUpTypeValue");
    }

    public static final Map<Integer, String> contactNumber1ColumnsMap = new HashMap<Integer, String>();

    static {
        contactNumber1ColumnsMap.put(35, "contactNumber");
        contactNumber1ColumnsMap.put(36, "contactNumberLookUpType.lookUpTypeValue");
    }

    public static final Map<Integer, String> contactNumber2ColumnsMap = new HashMap<Integer, String>();

    static {
        contactNumber2ColumnsMap.put(37, "contactNumber");
        contactNumber2ColumnsMap.put(38, "contactNumberLookUpType.lookUpTypeValue");
    }

    public static final Map<Integer, String> email1ColumnsMap = new HashMap<Integer, String>();

    static {
        email1ColumnsMap.put(39, "emailAddress");
    }

    public static final Map<Integer, String> email2ColumnsMap = new HashMap<Integer, String>();

    static {
        email2ColumnsMap.put(40, "emailAddress");
    }

    public static final Map<Integer, String> bankAccountColumnsMap = new HashMap<Integer, String>();

    static {
        bankAccountColumnsMap.put(41, "accountNumber");
        bankAccountColumnsMap.put(42, "accountHolder");
        bankAccountColumnsMap.put(43, "bankAccountLookUpType.lookUpTypeValue");
        bankAccountColumnsMap.put(44, "bankName");
        bankAccountColumnsMap.put(45, "bankBranch");
    }

    public static final Map<Integer, String> address1ColumnsMap = new HashMap<Integer, String>();

    static {
        address1ColumnsMap.put(46, "addressLine1");
        address1ColumnsMap.put(47, "addressLine2");
        address1ColumnsMap.put(48, "addressLine3");
        address1ColumnsMap.put(49, "postalCode");
        address1ColumnsMap.put(50, "comments");
        address1ColumnsMap.put(51, "addressLookUpType.lookUpTypeValue");
        address1ColumnsMap.put(52, "cityLookUpValue.lookUpTypeValue");
        address1ColumnsMap.put(53, "monthsAtResidence");
        address1ColumnsMap.put(54, "residenceLookUpType.lookUpTypeValue");
        address1ColumnsMap.put(55, "residentStatusLookUpValue.lookUpTypeValue");
    }

    public static final Map<Integer, String> address2ColumnsMap = new HashMap<Integer, String>();

    static {
        address2ColumnsMap.put(56, "addressLine1");
        address2ColumnsMap.put(57, "addressLine2");
        address2ColumnsMap.put(58, "addressLine3");
        address2ColumnsMap.put(59, "postalCode");
        address2ColumnsMap.put(60, "comments");
        address2ColumnsMap.put(61, "addressLookUpType.lookUpTypeValue");
        address2ColumnsMap.put(62, "cityLookUpValue.lookUpTypeValue");
        address2ColumnsMap.put(63, "monthsAtResidence");
        address2ColumnsMap.put(64, "residenceLookUpType.lookUpTypeValue");
        address2ColumnsMap.put(65, "residentStatusLookUpValue.lookUpTypeValue");
    }

    public static final Map<String,Map<Integer, String>> agentSheet = new LinkedHashMap<String, Map<Integer, String>>();

    static {
        agentSheet.put("agent",agentColumnsMap);
        agentSheet.put("person",personColumnsMap);
        agentSheet.put("contactNumber1",contactNumber1ColumnsMap);
        agentSheet.put("contactNumber2",contactNumber2ColumnsMap);
        agentSheet.put("emailAddress1",email1ColumnsMap);
        agentSheet.put("emailAddress2",email2ColumnsMap);
        agentSheet.put("bankAccount",bankAccountColumnsMap);
        agentSheet.put("address1",address1ColumnsMap);
        agentSheet.put("address2",address2ColumnsMap);
    }

}

package com.pkgMessageListLayout;

import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;

import java.io.File;

/**
 * Created by Dmitriy on 06.01.2018.
 */

public class ContactListItem
{
Resource ContactPicture;
String ContactName;
Integer SubjectId;

public ContactListItem( Resource vContactPicture, String vContactName, Integer vSubjectId )
{
ContactPicture = vContactPicture;
ContactName = vContactName;
SubjectId = vSubjectId;
}

public ContactListItem( String vContactPictureLink, String vContactName, Integer vSubjectId )
{
ContactPicture = new FileResource(new File(vContactPictureLink));
ContactName = vContactName;
SubjectId = vSubjectId;
}

public ContactListItem( FileResource FRContactPicture, String vContactName, Integer vSubjectId )
{
ContactPicture = FRContactPicture;
ContactName = vContactName;
SubjectId = vSubjectId;
}

}
;
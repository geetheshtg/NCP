<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
    <head>
     <link rel="stylesheet" type="text/css" href="proj.css"/>
    </head>
        <body>
            <table border="3" align="center" >
                <tr>
                    <th>first-name</th>
                    <th>last-name</th>
                    <th>username</th>
                    <th>position</th>
                    <th>company</th>
                    <th>skillset</th>
                </tr>
                <xsl:for-each select="/alumni-system/alumnus">
				<tr>
                    <td><xsl:value-of select="first-name"/></td>
                    <td><xsl:value-of select="last-name"/></td>
                    <td><xsl:value-of select="username"/></td>
                    <td><xsl:value-of select="position"/></td>
                    <td><xsl:value-of select="company"/></td>
                    <td><xsl:value-of select="skillset"/></td>
                </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>
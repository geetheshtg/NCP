<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
    <head>
     <link rel="stylesheet" type="text/css" href="bank.css"/>
    </head>
        <body>
            <table border="3" align="center" >
                <tr>
                    <th>customer-name</th>
                    <th>customer-street</th>
                    <th>customer-city</th>
                    <th>account-number</th>
                    <th>branch-name</th>
                    <th>balance</th>
					<th>recent-trans</th>
					<th>deposit</th>
					<th>withdraw</th>
					<th>loan</th>
                </tr>
                <xsl:for-each select="/banking/customer">
				<xsl:sort select="balance" data-type="number"/>
                <tr>
                    <td><xsl:value-of select="customer-name"/></td>
                    <td><xsl:value-of select="customer-street"/></td>
                    <td><xsl:value-of select="customer-city"/></td>
                    <td><xsl:value-of select="account-number"/></td>
                    <td><xsl:value-of select="branch-name"/></td>
                    <td><xsl:value-of select="balance"/></td>
					<td><xsl:value-of select="recent-trans"/></td>
					<td><xsl:value-of select="deposit"/></td>
					<td><xsl:value-of select="withdraw"/></td>
					<td><xsl:value-of select="loan"/></td>
                </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>
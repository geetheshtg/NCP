<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
    <table border="1">
      <tr bgcolor="#ADD8E6">
        <th>Region</th>
        <th>Location</th>
        <th>Feature Type</th>
        <th>ROV Type</th>
        <th>Area Covered</th>
        <th>Depth Range Surveyed(m)</th>
        <th>Distance from land(km)</th>
        <th>Shipping activity proxy</th>
        <th>Items(ha^(-1))</th>

      </tr>
      <xsl:for-each select="survey/cd">
      <tr>
        <td><xsl:value-of select="region" /></td>
        <td><xsl:value-of select="location" /></td>
        <td><xsl:value-of select="feature" /></td>
        <td><xsl:value-of select="rov" /></td>
        <td><xsl:value-of select="area" /></td>
        <td><xsl:value-of select="depth" /></td>
        <td><xsl:value-of select="dist" /></td>
        <td><xsl:value-of select="shipping" /></td>
        <td><xsl:value-of select="items" /></td>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>

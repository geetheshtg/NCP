<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

<xsl:template match="/">
  <html>
   <head>
   <link rel="stylesheet" type="text/css" href="hospital.css"/>
   </head>
  <body>
  <link rel="stylesheet" type="text/css" href="hospital.css"/>
  <h2>Patient Records</h2>
  <table border="1">
    <tr >
      <th>Patient Name</th>
      <th>Patient ID</th>
      <th>Patient Age</th>
      <th>Disease</th>
      <th>Treating Doctor</th>
      <th>Room Number</th>
    </tr>
    <xsl:for-each select="hospital/patient">
    <xsl:sort select="patname"/>
  
    
    <tr>
      <td><xsl:value-of select="patname"/></td>
      <td><xsl:value-of select="patid"/></td>
      <xsl:choose>
        <xsl:when test="patage &gt; 50">
      <td style="color:#2299ff"><xsl:value-of select="patage"/></td>
      </xsl:when>
        <xsl:otherwise>
         <td style="color:#ff2211"><xsl:value-of select="patage"/></td>
         </xsl:otherwise>
      </xsl:choose>
      <td><xsl:value-of select="disease"/></td>
      <td><xsl:value-of select="tdname"/></td>
      
      <td><xsl:value-of select="roomno"/></td>
      
  
    </tr>
    </xsl:for-each>
    
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
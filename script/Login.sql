USE [CadastroDB]
GO
/****** Object:  Table [dbo].[Clientes]    Script Date: 05-May-19 7:19:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](80) NOT NULL,
	[PasswordHash] VARBINARY(MAX) NOT NULL,
	[PasswordSait] VARBINARY(MAX) NULL
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[sp_User_Register]
	-- Add the parameters for the stored procedure here
	@Username nvarchar(80),
	@PasswordHash VARBINARY(MAX),
	@PasswordSait VARBINARY(MAX)

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	insert into [User] (  Username,PasswordHash,PasswordSait)
	values ( @Username,@PasswordHash,@PasswordSait)
END
GO
/****** Object:  StoredProcedure [dbo].[InsertValue]    Script Date: 05-May-19 7:19:31 PM ******/
SET ANSI_NULLS ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================

CREATE PROCEDURE [dbo].[sp_User_Exists] -- Add the parameters for the stored procedure here
 @Username nvarchar(80) 
 
 AS BEGIN -- SET NOCOUNT ON added to prevent extra result sets from
 -- interfering with SELECT statements.

SET NOCOUNT ON; IF EXISTS
  (SELECT Username
   FROM [User]
   WHERE Username = @Username) BEGIN
SELECT 1 'result' END ELSE BEGIN
SELECT 0 'result' END END  
/****** Object:  StoredProcedure [dbo].[InsertValue]    Script Date: 05-May-19 7:19:31 PM ******/
SET ANSI_NULLS ON 
GO

CREATE PROCEDURE [dbo].[sp_User_Login] -- Add the parameters for the stored procedure here
	@Username nvarchar(80)
 AS BEGIN -- SET NOCOUNT ON added to prevent extra result sets from
 -- interfering with SELECT statements.

SELECT PasswordHash,
  PasswordSait
   FROM [User]
   WHERE Username = @Username
   END  
/****** Object:  StoredProcedure [dbo].[InsertValue]    Script Date: 05-May-19 7:19:31 PM ******/
SET ANSI_NULLS ON 
GO


GRANT SELECT, INSERT, UPDATE, DELETE ON [CadastroDB].dbo.[User] TO delgado
GRANT execute ON [CadastroDB].dbo.sp_User_Exists TO delgado
GRANT execute ON [CadastroDB].dbo.sp_User_Register TO delgado
GRANT execute ON [CadastroDB].dbo.sp_User_Login TO delgado



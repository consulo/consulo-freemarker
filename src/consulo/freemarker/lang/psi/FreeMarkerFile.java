package consulo.freemarker.lang.psi;

import consulo.freemarker.FreeMarkerFileType;
import consulo.freemarker.lang.FreeMarkerLanguage;
import org.jetbrains.annotations.NotNull;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class FreeMarkerFile extends PsiFileBase
{
	public FreeMarkerFile(@NotNull FileViewProvider viewProvider)
	{
		super(viewProvider, FreeMarkerLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public FileType getFileType()
	{
		return FreeMarkerFileType.INSTANCE;
	}
}

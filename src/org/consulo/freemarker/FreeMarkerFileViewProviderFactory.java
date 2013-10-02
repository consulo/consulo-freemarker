package org.consulo.freemarker;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.FileViewProviderFactory;
import com.intellij.psi.PsiManager;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class FreeMarkerFileViewProviderFactory implements FileViewProviderFactory
{
	@Override
	public FileViewProvider createFileViewProvider(@NotNull VirtualFile virtualFile, Language language, @NotNull PsiManager psiManager, boolean b)
	{
		return new FreeMarkerFileViewProvider(psiManager, virtualFile, b);
	}
}
